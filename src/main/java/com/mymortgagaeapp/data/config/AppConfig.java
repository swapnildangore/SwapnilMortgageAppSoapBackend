package com.mymortgagaeapp.data.config;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.mymortgagaeapp.data.models.MortgageApplication;

/**
 * 
 * @author Swapnil Dangore
 */
@EnableWs
@Configuration
public class AppConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Set<MortgageApplication> applicationList() {
		MortgageApplication app = new MortgageApplication();

		Set<MortgageApplication> appList = new TreeSet<>(new MortgageAppComparator());

		app.setMortgageId("M1");
		app.setVersion("1");
		app.setOfferId("OI-1");
		app.setProductId("B1");

		app.setCreatedDate("09/08/2020");
		app.setOfferDate("09/08/2020");

		app.setOfferExpired(false);

		appList.add(app);

		return appList;
	}

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/mortgageApplication/*");
	}

	@Bean(name = "mortgageApplication")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentsSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("MortgageAppPort");
		definition.setTargetNamespace("http://mymortgageapp.com/mortgageApplications");
		definition.setLocationUri("/mortgageApplication");
		definition.setSchema(studentsSchema);
		return definition;
	}

	@Bean
	public XsdSchema studentsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schema/MortgageApplication.xsd"));
	}
}
