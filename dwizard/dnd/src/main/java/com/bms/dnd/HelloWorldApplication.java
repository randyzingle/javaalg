package com.bms.dnd;

import com.bms.dnd.db.HorseDAO;
import com.bms.dnd.resources.*;
import com.bms.dnd.health.*;
import com.bms.dnd.core.*;

import io.dropwizard.Application;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.*;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.configuration.*;

import org.slf4j.*;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);


	public static void main(String[] args) throws Exception{
		new HelloWorldApplication().run(args);
	}

	private final HibernateBundle<HelloWorldConfiguration> hibernate = 
		new HibernateBundle<HelloWorldConfiguration>(
				Horse.class
				) {
			@Override
			public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration config) {
				return config.getDataSourceFactory();
			}
		};
	
	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		LOGGER.info("Application initializing");	
		bootstrap.addBundle(hibernate);

        // Add a migration bundle for Liquibase database migrations
        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration config) {
                return config.getDataSourceFactory();
            }
        });

        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()
                )
        );
	}

	@Override
	public void run(HelloWorldConfiguration config, Environment env)
			throws Exception {
		LOGGER.info("Application running...");

        final HorseDAO horseDAO = new HorseDAO(hibernate.getSessionFactory());

		final HelloWorldResource hr = new HelloWorldResource(
				config.getTemplate(), 
				config.getDefaultName()
				);
		env.jersey().register(hr);
		final CharacterResource cr = new CharacterResource();
		env.jersey().register(cr);
        final HorseResource cor = new HorseResource(horseDAO);
        env.jersey().register(cor);

		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getTemplate());
		env.healthChecks().register("template", healthCheck);
		
	}

}
