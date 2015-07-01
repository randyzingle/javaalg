package com.bms.dnd;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.*;
import javax.validation.constraints.*;


public class HelloWorldConfiguration extends Configuration {
	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "Baldur";
	
	@JsonProperty
	public String getTemplate() {
		return template;
	}
	
//	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}
	
	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}
	
//	@JsonProperty
	public void setDefaultName(String name) {
		this.defaultName = name;
	}

	@Valid 
	@NotNull
    @JsonProperty
	private DataSourceFactory database = new DataSourceFactory();

	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
}
