package com.bms.base.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pet", schema="dnd")
@NamedQueries(value = {
		@NamedQuery(name="Pet.findAll", query="SELECT e FROM Pet e"),
		@NamedQuery(name="Pet.findByName", query="SELECT e FROM Pet e where name=:name")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	private String type;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="player_character_id")
//	@JsonIdentityReference(alwaysAsId=true) // without this a list of pets will have the full pc in the first element then ids
	private PlayerCharacter playerCharacter;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PlayerCharacter getPlayerCharacter() {
		return playerCharacter;
	}

	public void setPlayerCharacter(PlayerCharacter playerCharacter) {
		this.playerCharacter = playerCharacter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((playerCharacter == null) ? 0 : playerCharacter.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pet))
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playerCharacter == null) {
			if (other.playerCharacter != null)
				return false;
		} else if (!playerCharacter.equals(other.playerCharacter))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pet [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", age=");
		builder.append(age);
		builder.append(", playerCharacter=");
		builder.append(playerCharacter);
		builder.append("]");
		return builder.toString();
	}
	
}
