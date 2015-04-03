package com.bms.dnd;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception{
		new HelloWorldApplication().run(args);
	}
	
	@Override
	public String getName() {
		return "hello-world";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(HelloWorldConfiguration config, Environment env)
			throws Exception {
		final HelloWorldResource resource = new HelloWorldResource(
				config.getTemplate(), 
				config.getDefaultName()
				);
		env.jersey().register(resource);
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getTemplate());
		env.healthChecks().register("template", healthCheck);
		
	}

}
