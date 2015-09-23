package com.amplify.bauth.core;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: MetadataType
 *
 */
@Entity
@Table(name="metadata_type", schema = "burstauth")
public class MetadataType extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	public MetadataType(){}
	
	public MetadataType(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	@Column(length=255)
	private String name;  
	
	@Column(length=500)
	private String description;  
	
	//bi-directional many-to-one association to MetadataTag
	@OneToMany(mappedBy="metadataType")
    @ApiModelProperty(dataType = "[J")
	private List<MetadataTag> metadataTags;

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

	public List<MetadataTag> getMetadataTags() {
		return metadataTags;
	}

	public void setMetadataTags(List<MetadataTag> metadataTags) {
		this.metadataTags = metadataTags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((metadataTags == null) ? 0 : metadataTags.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof MetadataType))
			return false;
		MetadataType other = (MetadataType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (metadataTags == null) {
			if (other.metadataTags != null)
				return false;
		} else if (!metadataTags.equals(other.metadataTags))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
   
}
