package toby_project.config.autoconfig;

import org.eclipse.jetty.server.Server;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(Server.class)
@EnableConfigurationProperties(ServerProperties.class)
public class JettyWebServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory serverFactory(ServerProperties properties){
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();

        factory.setContextPath(properties.getServlet().getContextPath());
        factory.setPort(properties.getPort());

        return factory;
    }

}