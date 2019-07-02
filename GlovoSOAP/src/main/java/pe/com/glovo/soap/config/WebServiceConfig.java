package pe.com.glovo.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import pe.com.glovo.soap.endpoint.GlovoEndPoint;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(appContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/glovo/ws/*");
	}
	
	@Bean(name = "glovo")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();

		try {

			wsdl11Definition.setPortTypeName("GlovoPort");
			wsdl11Definition.setLocationUri("/glovo/ws");
			wsdl11Definition.setTargetNamespace(GlovoEndPoint.NAMESPACE_URI);
			wsdl11Definition.setSchema(schema);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return wsdl11Definition;
	}
	

	@Bean
	public XsdSchema glovoSchema() {
		return new SimpleXsdSchema(new 
				ClassPathResource("/xsd/glovo.xsd"));
	}

}
