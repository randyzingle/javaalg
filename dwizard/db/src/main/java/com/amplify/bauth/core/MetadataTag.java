package com.amplify.bauth.core;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: MetadataTag
 *
 */
@Entity
@Table(name="metadata_tag", schema = "burstauth")
public class MetadataTag extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	public MetadataTag() {}
	
	public MetadataTag(String name, MetadataType metadataType) {
		super();
		this.name = name;
		this.metadataType = metadataType;
	}
	
	@Column(length=255)
	private String name;  
	
	//bi-directional many-to-one association to MetadataType
	@ManyToOne
	@JoinColumn(name="metadata_type_id", nullable=false)
	private MetadataType metadataType;
	
	@ManyToMany(mappedBy="metadataTags")
    @ApiModelProperty(dataType = "[J")
	private List<ActivityElement> activityElements;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MetadataType getMetadataType() {
		return metadataType;
	}

	public void setMetadataType(MetadataType metadataType) {
		this.metadataType = metadataType;
	}

	public List<ActivityElement> getActivityElements() {
		return activityElements;
	}

	public void setActivityElements(List<ActivityElement> activityElements) {
		this.activityElements = activityElements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((activityElements == null) ? 0 : activityElements.hashCode());
		result = prime * result
				+ ((metadataType == null) ? 0 : metadataType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof MetadataTag))
			return false;
		MetadataTag other = (MetadataTag) obj;
		if (activityElements == null) {
			if (other.activityElements != null)
				return false;
		} else if (!activityElements.equals(other.activityElements))
			return false;
		if (metadataType == null) {
			if (other.metadataType != null)
				return false;
		} else if (!metadataType.equals(other.metadataType))
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
