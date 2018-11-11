package com.dlocal.merchant;

import com.mongodb.Mongo;
import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class MerchantApplication extends SpringBootServletInitializer {

	@Autowired
	private Environment env;

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory()
	{
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		factory.setContextPath("/api");
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
		return factory;
	}

	@Bean
	public void loadInitialData() {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("/mongeez.xml"));
		mongeez.setMongo(new Mongo(env.getProperty("mongo.url"), Integer.parseInt(env.getProperty("mongo.port"))));
		mongeez.setDbName(env.getProperty("mongo.name"));
		mongeez.process();
	}

	public static void main(String[] args) {
		new MerchantApplication().configure(new SpringApplicationBuilder(MerchantApplication.class)).run(args);
	}
}
