package com.amplify.bauth.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BaseEntity() {
		Timestamp ts = new Timestamp((new java.util.Date()).getTime());
		this.createdOn = ts;
		this.modifiedOn = ts;
		this.uuid = UUID.randomUUID().toString();
		this.version = 1;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PublicView.class)
    private Long id;
    
	@Column
    @JsonView(ExtendedPublicView.class)
	private Integer version;

	@Column
    @JsonView(ExtendedPublicView.class)
	private String uuid;

	@Column(columnDefinition = "timestamp with time zone")
    @JsonView(ExtendedPublicView.class)
	private Timestamp createdOn;

	@Column(columnDefinition = "timestamp with time zone")
    @JsonView(ExtendedPublicView.class)
	private Timestamp modifiedOn;
    
    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getUuid() {
		return uuid;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String toJson() {
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        try
        {
            result = writer.writeValueAsString(this);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    @Override
	public String toString() {
        String format = "%s : id = %s, uuid = %s, version = %s";
        return String.format(format, getClass().getName(), getId(), getUuid(), getVersion());
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

    public static class PublicView { }
    public static class ExtendedPublicView extends PublicView { }

}
