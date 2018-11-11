package com.dlocal.merchant;

import com.mongodb.Mongo;
import org.mongeez.Mongeez;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class MerchantApplication extends SpringBootServletInitializer {

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory()
	{
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		factory.setContextPath("/api");
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
		return factory;
	}

	@Bean(initMethod = "process")
	public Mongeez loadInitialData() {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("/mongeez.xml"));
		mongeez.setMongo(new Mongo("localhost", 27017));
		mongeez.setDbName("merchantDB");
		mongeez.process();
		return mongeez;
	}

	public static void main(String[] args) {
		new MerchantApplication().configure(new SpringApplicationBuilder(MerchantApplication.class)).run(args);
	}
}
