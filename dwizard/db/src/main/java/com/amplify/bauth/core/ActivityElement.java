package com.amplify.bauth.core;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.amplify.bauth.core.enums.ActivityElementType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="activity_element", schema = "burstauth")
@NamedQuery(name="ActivityElement.findAll", query="SELECT a FROM ActivityElement a")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ActivityElement extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	public ActivityElement() {
    }

    public ActivityElement(Data activityElementData) {
        this.activityElementData = activityElementData;
    }

    /**
	 * @param pandaId Generated ID from Panda database
	 * @param name For Panda Elements use Panda name, for others create unique name
	 * @param configJSON JSON block used to configure activity element
	 * @param type value from {@link ActivityElementEnum} 
	 * @param urlPath subpath to S3 bucket which contains assets for non-Panda items
	 * @param metadataTags tags used as filtering criteria in searches
	 */
	public ActivityElement(Long pandaId, String name, String configJSON,
			ActivityElementType type, String urlPath, List<MetadataTag> metadataTags) {
		super();
        this.activityElementData = new Data(name, pandaId, configJSON, 0, type, urlPath, null, null);
		this.metadataTags = metadataTags;
	}

    @Embedded
    private Data activityElementData;
	
	// metadata used for filtering searches
	@ManyToMany
	@JoinTable(name="activity_element_metadata_tag", schema="burstauth",
			joinColumns={@JoinColumn(name="activity_element_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="metadata_tag_id", referencedColumnName="id")}
	)
	private List<MetadataTag> metadataTags;

	public Long getPandaId() {
		return this.activityElementData.pandaId;
	}

	public void setPandaId(Long activityId) {
		this.activityElementData.pandaId = activityId;
	}

	public String getName() {
		return activityElementData.name;
	}

	public void setName(String name) {
		this.activityElementData.name = name;
	}

	public String getConfigJSON() {
		return activityElementData.configJSON;
	}

	public void setConfigJSON(String configJSON) {
		this.activityElementData.configJSON = configJSON;
	}

	public ActivityElementType getType() {
		return this.activityElementData.type;
	}

	public void setType(ActivityElementType type) {
		this.activityElementData.type = type;
	}

    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "java.lang.Long")
	public Lesson getLesson() {
		return this.activityElementData.lesson;
	}

	public void setLesson(Lesson lesson) {
		this.activityElementData.lesson = lesson;
	}

    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "java.lang.Long")
	public SubUnit getSubunit() {
		return this.activityElementData.subunit;
	}

	public void setSubunit(SubUnit subUnit) {
		this.activityElementData.subunit = subUnit;
	}

	public Integer getSequenceNumber() {
		return activityElementData.sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.activityElementData.sequenceNumber = sequenceNumber;
	}

	public String getUrlPath() {
		return activityElementData.urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.activityElementData.urlPath = urlPath;
	}

	public List<MetadataTag> getMetadataTags() {
		return metadataTags;
	}

	public void setMetadataTags(List<MetadataTag> metadataTags) {
		this.metadataTags = metadataTags;
	}

    public void setActivityElementData(Data activityElementData) {
        this.activityElementData = activityElementData;
    }

    public Data getActivityElementData() {
        return activityElementData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ActivityElement that = (ActivityElement) o;

        if (activityElementData != null ? !activityElementData.equals(that.activityElementData) : that.activityElementData != null) return false;
        if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (activityElementData != null ? activityElementData.hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
	public String toString() {
        String format = "%s name = %s, sequenceNumber = %s";
        return String.format(format, super.toString(), getName(), getSequenceNumber());
	}

    @Embeddable
    @ApiModel(value = "ActivityElementData")
    public static class Data {

        @Column(name="name", nullable=false)
        private String name;

        @Column(name="panda_id", nullable=true)
        private Long pandaId;

        @Lob
        @Type(type="org.hibernate.type.StringClobType")
        @Column(name="config_json", nullable=true)
        private String configJSON;

        @Column(name="sequence_number", nullable=true)
        private Integer sequenceNumber;

        @Enumerated(EnumType.STRING)
        @Column(name="type", nullable=false)
        private ActivityElementType type;

        @Column(name="url_path", nullable=true)
        private String urlPath;

        //bi-directional many-to-one association to Lesson
        @ManyToOne
        @JoinColumn(name="lesson_id", nullable=true)
        @JsonIdentityReference(alwaysAsId=true)
        @ApiModelProperty(dataType = "java.lang.Long")
        private Lesson lesson;

        //bi-directional many-to-one association to SubUnit
        @ManyToOne
        @JoinColumn(name="subunit_id", nullable=true)
        @JsonIdentityReference(alwaysAsId=true)
        @ApiModelProperty(dataType = "java.lang.Long")
        private SubUnit subunit;

        public Data() {
        }

        public Data(@JsonProperty(value = "name") String name,
                    @JsonProperty(value = "pandaId") Long pandaId,
                    @JsonProperty(value = "configJSON") String configJSON,
                    @JsonProperty(value = "sequenceNumber") Integer sequenceNumber,
                    @JsonProperty(value = "type") ActivityElementType type,
                    @JsonProperty(value = "urlPath") String urlPath,
                    @JsonProperty(value = "lesson") Long lessonId,
                    @JsonProperty(value = "subunit") Long subunitId) {
            this.name = name;
            this.pandaId = pandaId;
            this.configJSON = configJSON;
            this.sequenceNumber = sequenceNumber;
            this.type = type;
            this.urlPath = urlPath;

            if(lessonId != null) {
                this.lesson = new Lesson();
                this.lesson.setId(lessonId);
            }

            if(subunitId != null) {
                this.subunit = new SubUnit();
                this.subunit.setId(subunitId);
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPandaId() {
            return pandaId;
        }

        public void setPandaId(Long pandaId) {
            this.pandaId = pandaId;
        }

        public String getConfigJSON() {
            return configJSON;
        }

        public void setConfigJSON(String configJSON) {
            this.configJSON = configJSON;
        }

        public Integer getSequenceNumber() {
            return sequenceNumber;
        }

        public void setSequenceNumber(Integer sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }

        public ActivityElementType getType() {
            return type;
        }

        public void setType(ActivityElementType type) {
            this.type = type;
        }

        public String getUrlPath() {
            return urlPath;
        }

        public void setUrlPath(String urlPath) {
            this.urlPath = urlPath;
        }

        public Lesson getLesson() {
            return lesson;
        }

        public void setLesson(Lesson lesson) {
            this.lesson = lesson;
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
