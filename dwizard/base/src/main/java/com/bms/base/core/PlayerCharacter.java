package com.bms.base.core;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="player_character", schema = "dnd")
@NamedQueries(value = {
		@NamedQuery(name="PlayerCharacter.findAll", query="FROM PlayerCharacter e left join e.pets"),
		@NamedQuery(name="PlayerCharacter.findByName", query="SELECT e FROM PlayerCharacter e where name=:name")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayerCharacter {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private String race;
	private int age;
	
	@OneToMany(mappedBy="playerCharacter", fetch = FetchType.EAGER)
//	@JsonIdentityReference(alwaysAsId=true)
	private Set<Pet> pets;
	
	public PlayerCharacter(){}
	
	public PlayerCharacter(String name, String race, int age) {
		this.name = name;
		this.race = race;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PlayerCharacter))
			return false;
		PlayerCharacter other = (PlayerCharacter) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerCharacter [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", race=");
		builder.append(race);
		builder.append(", age=");
		builder.append(age);
		builder.append(", pets=");
		builder.append(pets.size());
		builder.append("]");
		return builder.toString();
	}

}
