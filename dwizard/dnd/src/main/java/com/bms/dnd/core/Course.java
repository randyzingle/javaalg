package com.bms.dnd.core;

import java.io.Serializable;

import javax.persistence.*;

import java.util.*;
import java.sql.Timestamp;

/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course", schema = "burst", uniqueConstraints = 
	{ @UniqueConstraint(columnNames = { "grade", "title", "version" }) })
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course extends BaseEntity {
	private static final long serialVersionUID = 1L;

	Course() {}

    public Course(String grade, String title, Integer version, String uuid) {
        this(grade, title, null, version, uuid);
    }
	
	public Course(String grade, String title, List<Unit> units,
			Integer version, String uuid) {
		super();
		this.grade = grade;
		this.title = title;
		this.units = units;
		this.version = version;
		this.uuid = uuid;
	}

	@Column(length=10)
	private String grade;

	@Column(length=255)
	private String title;
	
	@OneToMany(mappedBy="course")
	private List<Unit> units;

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(List<Unit> units) {
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
}