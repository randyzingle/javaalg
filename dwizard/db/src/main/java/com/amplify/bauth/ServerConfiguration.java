package com.amplify.bauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServerConfiguration extends Configuration {

    @NotEmpty
    private String applicationName = "burst-authoring-server";

    @JsonProperty
    public String getApplicationName() {
        return applicationName;
    }

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
