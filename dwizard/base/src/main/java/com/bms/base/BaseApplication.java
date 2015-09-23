package com.bms.base;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.base.core.Pet;
import com.bms.base.core.PlayerCharacter;
import com.bms.base.db.PetDAO;
import com.bms.base.db.PlayerCharacterDAO;
import com.bms.base.resources.PetResource;

public class BaseApplication extends Application<BaseConfiguration> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseApplication.class);
	
    @Override
    public String getName() {
        return "base";
    }
	
    // register all of the JPA Entities with Hibernate
    private final HibernateBundle<BaseConfiguration> hibernateBundle =
            new HibernateBundle<BaseConfiguration>(
                    PlayerCharacter.class,
                    Pet.class
                    )	{
                		@Override
                		public DataSourceFactory getDataSourceFactory(BaseConfiguration configuration) {
                			return configuration.getDataSourceFactory();
                		}
            };
	
	public static void main(String[] args) throws Exception {
		new BaseApplication().run(args);
	}
	
    @Override
    public void initialize(Bootstrap<BaseConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        LOGGER.info("{} initialize completed", getName());
    }

	@Override
	public void run(BaseConfiguration conf, Environment env) throws Exception {
		PlayerCharacterDAO pcdao = new PlayerCharacterDAO(hibernateBundle.getSessionFactory());
		env.jersey().register(new com.bms.base.resources.PlayerCharacterResource(pcdao));
		
		PetDAO petdao = new PetDAO(hibernateBundle.getSessionFactory());
		env.jersey().register(new PetResource(petdao));
		
		LOGGER.info("{} run completed", getName());
		
	}

}
