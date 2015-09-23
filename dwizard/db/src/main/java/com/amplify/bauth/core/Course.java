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
@Table(name = "course", schema = "burstauth", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"grade", "title", "version"})})
@NamedQuery(name = "Course.findAll", query = "SELECT s FROM com.amplify.bauth.core.Course s left join fetch s.units")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public Course() {}

	public Course(String grade, String title) {
		super();
        this.courseData = new Data(grade, title);
	}

    public Course(Data courseData) {
        this.courseData = courseData;
    }

    private Data courseData;
	
	@OneToMany(mappedBy="unitData.course", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId=true)
    @ApiModelProperty(dataType = "[J")
	private Set<Unit> units;

	public String getGrade() {
		return this.courseData.getGrade();
	}

	public void setGrade(String grade) {
		this.courseData.setGrade(grade);
	}

	public String getTitle() {
		return this.courseData.getTitle();
	}

	public void setTitle(String title) {
		this.courseData.setTitle(title);
	}

	public Set<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setCourse(this);
		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setCourse(null);
		return unit;
	}

    public void setCourseData(Data courseData) {
        this.courseData = courseData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Course course = (Course) o;

        if (courseData != null ? !courseData.equals(course.courseData) : course.courseData != null) return false;
        if (getVersion() != null ? !getVersion().equals(course.getVersion()) : course.getVersion() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (courseData != null ? courseData.hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String format = "%s title = %s, grade = %s";
        return String.format(format, super.toString(), getTitle(), getGrade());
    }

    @Embeddable
    @ApiModel(value = "CourseData")
    public static class Data {

        @ApiModelProperty(name = "grade")
        @Column(length = 10)
        private String grade;

        @ApiModelProperty(name = "title")
        @Column(length=255)
        private String title;

        public Data() {}

        public Data(@JsonProperty(value= "grade") String grade, @JsonProperty(value = "title") String title) {
            this.grade = grade;
            this.title = title;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (grade != null ? !grade.equals(data.grade) : data.grade != null) return false;
            if (title != null ? !title.equals(data.title) : data.title != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = grade != null ? grade.hashCode() : 0;
            result = 31 * result + (title != null ? title.hashCode() : 0);
            return result;
        }
    }
}
