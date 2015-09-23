package com.amplify.bauth;

import com.amplify.bauth.core.*;
//import com.amplify.bauth.db.GenericDAOFactory;
//import com.amplify.bauth.resources.*;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


public class Server extends Application<ServerConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    @Override
    public String getName() {
        return "burst-authoring-server";
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.run(args);
    }

    // register all of the JPA Entities with Hibernate
    private final HibernateBundle<ServerConfiguration> hibernateBundle =
            new HibernateBundle<ServerConfiguration>(
                    ActivityElement.class,
                    BaseEntity.class,
                    Course.class,
                    Lesson.class,
                    MetadataTag.class,
                    MetadataType.class,
                    SubUnit.class,
                    Unit.class
                    ) {
                @Override
            public DataSourceFactory getDataSourceFactory(ServerConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new MigrationsBundle<ServerConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ServerConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        LOGGER.info("{} initialize completed", getName());
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) throws Exception {

//        GenericDAOFactory.initialize(hibernateBundle.getSessionFactory());

        FilterHolder filter = environment.getApplicationContext().addFilter(CrossOriginFilter.class, "/*", 
        		EnumSet.allOf(DispatcherType.class));
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PATCH,POST,DELETE,OPTIONS");

        configureSwagger(configuration, environment);

        LOGGER.info("{} run completed", getName());
    }

    public void configureSwagger(ServerConfiguration configuration, Environment environment) {

        environment.jersey().register(new ApiListingResource());

        BeanConfig config = new BeanConfig();
        config.setTitle("Burst Authoring Server");
        config.setVersion("1.0.0");
        config.setResourcePackage("com.amplify.bauth.resources");
        config.setScan(true);
        config.setBasePath("/burst-authoring");
        config.setPrettyPrint("true");
    }
}
