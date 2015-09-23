package com.amplify.bauth.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="unit", schema = "burstauth")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u left join fetch u.subunits")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ApiModel(value = "Unit")
public class Unit extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public Unit() {}

	public Unit(String name, String description, String lpSectionUuid,
			String lpSectionName, Course course) {
		super();
		this.unitData = new Data(name, description, lpSectionUuid, lpSectionName, course);
	}

    public Unit(Data unitData) {
        super();
        this.unitData = unitData;
    }

    @Embedded
    private Data unitData;

	//bi-directional many-to-one association to SubUnit
	@OneToMany(mappedBy="subunitData.unit", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "[J")
	private Set<SubUnit> subunits;

	public String getDescription() {
		return this.unitData.getDescription();
	}

	public void setDescription(String description) {
		this.unitData.setDescription(description);
	}

	public String getName() {
		return this.unitData.getName();
	}

	public void setName(String name) {
		this.unitData.setName(name);
	}

	public Set<SubUnit> getSubunits() {
		return this.subunits;
	}

	public void setSubunits(Set<SubUnit> subUnits) {
		this.subunits = subUnits;
	}

	public SubUnit addSubUnit(SubUnit subUnit) {
		getSubunits().add(subUnit);
		subUnit.setUnit(this);

		return subUnit;
	}

	public SubUnit removeSubUnit(SubUnit subUnit) {
		getSubunits().remove(subUnit);
		subUnit.setUnit(null);

		return subUnit;
	}

    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "java.lang.Long")
	public Course getCourse() {
		return this.unitData.course;
	}

	public void setCourse(Course course) {
		this.unitData.course = course;
	}

	public String getLpSectionUuid() {
		return this.unitData.getLpSectionUuid();
	}

	public void setLpSectionUuid(String lpSectionUuid) {
		this.unitData.setLpSectionUuid(lpSectionUuid);
	}

	public String getLpSectionName() {
		return this.unitData.getLpSectionName();
	}

	public void setLpSectionName(String lpSectionName) {
		this.unitData.setLpSectionName(lpSectionName);
	}

    public void setUnitData(Data unitData) {
        this.unitData = unitData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Unit unit = (Unit) o;

        if (unitData != null ? !unitData.equals(unit.unitData) : unit.unitData != null) return false;
        if (getVersion() != null ? !getVersion().equals(unit.getVersion()) : unit.getVersion() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (unitData != null ? unitData.hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String format = "%s name = %s";
        return String.format(format, super.toString(), getName());
    }


    @Embeddable
    @ApiModel(value = "UnitData")
    public static class Data {

        @Column(length=255)
        private String name;

        @Column
        private String description;

        @Column(name="lp_section_uuid")
        private String lpSectionUuid;

        @Column(name="lp_section_name")
        private String lpSectionName;

        //bi-directional many-to-one association to Course
        @ManyToOne
        @JoinColumn(name="course_id", nullable=false)
        @JsonIdentityReference(alwaysAsId=true)
        @ApiModelProperty(dataType = "java.lang.Long")
        private Course course;

        public Data() {}

        public Data(String name, String description, String lpSectionUuid, String lpSectionName) {
            this.name = name;
            this.description = description;
            this.lpSectionUuid = lpSectionUuid;
            this.lpSectionName = lpSectionName;
        }

        public Data(String name, String description, String lpSectionUuid, String lpSectionName, Course course) {
            this(name, description, lpSectionUuid, lpSectionName);
            this.course = course;
        }

        public Data(@JsonProperty(value = "name") String name, @JsonProperty(value = "description") String description,
                    @JsonProperty(value = "lpSectionUuid") String lpSectionUuid,
                    @JsonProperty(value = "lpSectionName") String lpSectionName,
                    @JsonProperty(value = "course") Long courseId) {
            this(name, description, lpSectionUuid, lpSectionName);
            this.course = new Course();
            this.course.setId(courseId);
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

        public String getLpSectionUuid() {
            return lpSectionUuid;
        }

        public void setLpSectionUuid(String lpSectionUuid) {
            this.lpSectionUuid = lpSectionUuid;
        }

        public String getLpSectionName() {
            return lpSectionName;
        }

        public void setLpSectionName(String lpSectionName) {
            this.lpSectionName = lpSectionName;
        }


        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
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
