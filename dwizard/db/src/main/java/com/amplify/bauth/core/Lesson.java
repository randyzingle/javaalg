package com.amplify.bauth.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.Set;


@Entity
@Table(name="lesson", schema = "burstauth")
@NamedQuery(name="Lesson.findAll", query="SELECT l FROM Lesson l")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lesson extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public Lesson() {}

	public Lesson(String description, Integer lessonNumber, String name, SubUnit subUnit) {
		super();
	}

    public Lesson(Data lessonData) {
        this.lessonData = lessonData;
    }

    @Embedded
    private Data lessonData;

	//bi-directional many-to-one association to ActivityElement
	@OneToMany(mappedBy="activityElementData.lesson", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "[J")
	private Set<ActivityElement> activityElements;

	public String getDescription() {
		return this.lessonData.description;
	}

	public void setDescription(String description) {
		this.lessonData.description = description;
	}

	public String getName() {
		return this.lessonData.name;
	}

	public void setName(String name) {
		this.lessonData.name = name;
	}

	public int getLessonNumber() {
		return this.lessonData.lessonNumber;
	}

	public void setLessonNumber(int lessonNumber) {
		this.lessonData.lessonNumber = lessonNumber;
	}

	public String getAuthLabel() {
		return this.lessonData.authLabel;
	}

	public void setAuthLabel(String authLabel) {
		this.lessonData.authLabel = authLabel;
	}

	public Set<ActivityElement> getActivityElements() {
		return this.activityElements;
	}

	public void setActivityElements(Set<ActivityElement> activityElements) {
		this.activityElements = activityElements;
	}

	public ActivityElement addActivityElement(ActivityElement activityElement) {
		getActivityElements().add(activityElement);
		activityElement.setLesson(this);
		return activityElement;
	}

	public ActivityElement removeActivityElement(ActivityElement activityElement) {
		getActivityElements().remove(activityElement);
		activityElement.setLesson(null);
		return activityElement;
	}

    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "java.lang.Long")
	public SubUnit getSubunit() {
		return this.lessonData.subunit;
	}

	public void setSubunit(SubUnit subUnit) {
		this.lessonData.subunit = subUnit;
	}

	public Integer getSequenceNumber() {
		return this.lessonData.sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.lessonData.sequenceNumber = sequenceNumber;
	}

	public String getConfigJSON() {
		return this.lessonData.configJSON;
	}

	public void setConfigJSON(String configJSON) {
		this.lessonData.configJSON = configJSON;
	}


    public void setLessonData(Data lessonData) {
        this.lessonData = lessonData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Lesson lesson = (Lesson) o;

        if (lessonData != null ? !lessonData.equals(lesson.lessonData) : lesson.lessonData != null) return false;
        if (getVersion() != null ? !getVersion().equals(lesson.getVersion()) : lesson.getVersion() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lessonData != null ? lessonData.hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String format = "%s name = %s";
        return String.format(format, super.toString(), getName());
    }

    @Embeddable
    @ApiModel(value = "LessonData")
    public static class Data {

        @Column(length=500)
        private String description;

        @Column(name="sequence_number")
        private Integer sequenceNumber;

        @Column(length=255, nullable=false)
        private String name;

        @Column(name="lesson_number", nullable=false)
        private int lessonNumber; // user-facing number

        @Column(name="auth_label", length=40)
        private String authLabel; // admin-facing label like DVM_E_4_1

        @Lob
        @Type(type="org.hibernate.type.StringClobType")
        @Column(name="config_json")
        private String configJSON;

        //bi-directional many-to-one association to SubUnit
        @ManyToOne
        @JoinColumn(name="sub_unit_id", nullable=false)
        @JsonIdentityReference(alwaysAsId=true)
        @ApiModelProperty(dataType = "java.lang.Long")
        private SubUnit subunit;

        public Data() {
        }

        public Data(String name, String description, int lessonNumber, String authLabel, String configJSON) {
            this.description = description;
            this.name = name;
            this.lessonNumber = lessonNumber;
            this.authLabel = authLabel;
            this.configJSON = configJSON;
        }

        public Data(String name, String description, int lessonNumber, String authLabel, String configJSON, SubUnit subunit) {
            this(name, description, lessonNumber, authLabel, configJSON);
            this.subunit = subunit;
        }

        public Data(@JsonProperty(value = "name") String name, @JsonProperty(value = "description") String description,
                    @JsonProperty(value = "lessonNumber") int lessonNumber,
                    @JsonProperty(value = "authLabel") String authLabel,
                    @JsonProperty(value = "configJSON") String configJSON,
                    @JsonProperty(value = "subunit") Long subunitId) {
            this(name, description, lessonNumber, authLabel, configJSON);
            this.subunit = new SubUnit();
            this.subunit.setId(subunitId);
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getSequenceNumber() {
            return sequenceNumber;
        }

        public void setSequenceNumber(Integer sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLessonNumber() {
            return lessonNumber;
        }

        public void setLessonNumber(int lessonNumber) {
            this.lessonNumber = lessonNumber;
        }

        public String getAuthLabel() {
            return authLabel;
        }

        public void setAuthLabel(String authLabel) {
            this.authLabel = authLabel;
        }

        public String getConfigJSON() {
            return configJSON;
        }

        public void setConfigJSON(String configJSON) {
            this.configJSON = configJSON;
        }

        public SubUnit getSubunit() {
            return subunit;
        }

        public void setSubunit(SubUnit subunit) {
            this.subunit = subunit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (name != null ? !name.equals(data.name) : data.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}
