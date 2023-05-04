package it.beije.boot.rubrica.controller.nicoleSOAP;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import it.beije.boot.rubrica.model.nicole.Contact;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(Contact applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext((org.springframework.context.ApplicationContext) applicationContext);

		return new ServletRegistrationBean(servlet, "it.beije.boot.rubrica.model.nicole");
	}
	@Bean(name="Contact")
	public Wsdl11Definition defaultWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/Contact.wsdl"));

		return wsdl11Definition;
	}

}
