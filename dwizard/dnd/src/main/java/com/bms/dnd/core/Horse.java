package com.bms.dnd.core;

import javax.persistence.*;

import java.util.*;

/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="horse", schema = "burst")
@NamedQuery(name="Horse.findAll", query="SELECT c FROM Horse c")
public class Horse {
	private static final long serialVersionUID = 1L;

	Horse() {}
	
	public Horse(String grade, String title, Integer version, String uuid) {
		super();
		this.grade = grade;
		this.title = title;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    public Long getId() {
        return id;
    }

	@Column(length=10)
	private String grade;

	@Column(length=255)
	private String title;

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

}