package com.emerald.gdd;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * This class extends and configures the Tomcat container servlet. Allows
 * setting of MimeMappings programmatically, instead of through XML declarations.
 *
 * @author C4X2
 *
 */
@Component
public class ApplicationServletContainer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory>
{
	@Override
	public void customize(TomcatServletWebServerFactory factory)
	{
		MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
		mappings.add("jsp", "text/xhtml");
		factory.setMimeMappings(mappings);
	}
}
