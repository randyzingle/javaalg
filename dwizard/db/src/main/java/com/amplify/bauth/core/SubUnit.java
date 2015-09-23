package com.amplify.bauth.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="sub_unit", schema = "burstauth")
@NamedQuery(name="SubUnit.findAll", query="SELECT s FROM SubUnit s")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubUnit extends BaseEntity {

    private static final long serialVersionUID = 1L;
	
	public SubUnit() {}

	public SubUnit(String name, String description, String lpLevelUuid, String lpLevelName, Unit unit) {
		super();
        subunitData = new Data(name, description, 0, lpLevelUuid, lpLevelName, unit);
	}

    public SubUnit(Data subunitData) {
        this.subunitData = subunitData;
    }

    @Embedded
    private Data subunitData;

	//bi-directional many-to-one association to ActivityElement
	@OneToMany(mappedBy="activityElementData.subunit")
    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "[J")
	private List<ActivityElement> activityElements;

	//bi-directional many-to-one association to Lesson
	@OneToMany(mappedBy="lessonData.subunit", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "[J")
	private Set<Lesson> lessons;

	public String getDescription() {
		return this.subunitData.description;
	}

	public void setDescription(String description) {
		this.subunitData.description = description;
	}

	public String getName() {
		return this.subunitData.name;
	}

	public void setName(String name) {
		this.subunitData.name = name;
	}
	
	public int getSubunitNumber() {
		return this.subunitData.subunitNumber;
	}

	public void setSubunitNumber(int subunitNumber) {
		this.subunitData.subunitNumber = subunitNumber;
	}

	public List<ActivityElement> getActivityElements() {
		return this.activityElements;
	}

	public void setActivityElements(List<ActivityElement> activityElements) {
		this.activityElements = activityElements;
	}

	public ActivityElement addActivityElement(ActivityElement activityElement) {
		getActivityElements().add(activityElement);
		activityElement.setSubunit(this);

		return activityElement;
	}

	public ActivityElement removeActivityElement(ActivityElement activityElement) {
		getActivityElements().remove(activityElement);
		activityElement.setSubunit(null);

		return activityElement;
	}

	public Set<Lesson> getLessons() {
		return this.lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Lesson addLesson(Lesson lesson) {
		getLessons().add(lesson);
		lesson.setSubunit(this);

		return lesson;
	}

	public Lesson removeLesson(Lesson lesson) {
		getLessons().remove(lesson);
		lesson.setSubunit(null);

		return lesson;
	}

    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "java.lang.Long")
	public Unit getUnit() {
		return this.subunitData.unit;
	}

	public void setUnit(Unit unit) {
		this.subunitData.unit = unit;
	}

	public String getLpLevelUuid() {
		return this.subunitData.lpLevelUuid;
	}

	public void setLpLevelUuid(String lpLevelUuid) {
		this.subunitData.lpLevelUuid = lpLevelUuid;
	}

	public String getLpLevelName() {
		return subunitData.lpLevelName;
	}

	public void setLpLevelName(String lpLevelName) {
		this.subunitData.lpLevelName = lpLevelName;
	}

    public void setSubunitData(Data subunitData) {
        this.subunitData = subunitData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SubUnit subUnit = (SubUnit) o;

        if (subunitData != null ? !subunitData.equals(subUnit.subunitData) : subUnit.subunitData != null) return false;
        if (getVersion() != null ? !getVersion().equals(subUnit.getVersion()) : subUnit.getVersion() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (subunitData != null ? subunitData.hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String format = "%s name = %s";
        return String.format(format, super.toString(), getName());
    }

    @Embeddable
    @ApiModel(value = "SubunitData")
    public static class Data {

        @Column(length=255)
        private String name;

        @Column(length=255)
        private String description;

        @Column(name="subunit_number")
        private int subunitNumber; // user-facing number

        @Column(name="lp_level_uuid")
        private String lpLevelUuid;

        @Column(name="lp_level_name")
        private String lpLevelName;

        //bi-directional many-to-one association to Unit
        @ManyToOne
        @JoinColumn(name="unit_id", nullable=false)
        @JsonIdentityReference(alwaysAsId=true)
        @ApiModelProperty(dataType = "java.lang.Long")
        private Unit unit;

        public Data() {}

        public Data(String name, String description, int subunitNumber, String lpLevelUuid, String lpLevelName) {
            this.name = name;
            this.description = description;
            this.subunitNumber = subunitNumber;
            this.lpLevelUuid = lpLevelUuid;
            this.lpLevelName = lpLevelName;
        }

        public Data(String name, String description, int subunitNumber, String lpLevelUuid, String lpLevelName, Unit unit) {
            this(name, description, subunitNumber, lpLevelUuid, lpLevelName);
            this.unit = unit;
        }

        public Data(@JsonProperty(value = "name") String name, @JsonProperty(value = "description") String description,
                    @JsonProperty(value = "subunitNumber") int subunitNumber,
                    @JsonProperty(value = "lpLevelUuid") String lpLevelUuid,
                    @JsonProperty(value = "lpLevelName") String lpLevelName,
                    @JsonProperty(value = "unit") Long unitId) {
            this(name, description, subunitNumber, lpLevelUuid, lpLevelName);
            this.unit = new Unit();
            this.unit.setId(unitId);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSubunitNumber() {
            return subunitNumber;
        }

        public void setSubunitNumber(int subunitNumber) {
            this.subunitNumber = subunitNumber;
        }

        public String getLpLevelUuid() {
            return lpLevelUuid;
        }

        public void setLpLevelUuid(String lpLevelUuid) {
            this.lpLevelUuid = lpLevelUuid;
        }

        public String getLpLevelName() {
            return lpLevelName;
        }

        public void setLpLevelName(String lpLevelName) {
            this.lpLevelName = lpLevelName;
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
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
