package edu.qust.market;

import edu.qust.market.utils.AccessTokenUtil;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
        AccessTokenUtil.getAccess_token();
    }

    @Bean
    public Connector connector() {

        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");

        connector.setScheme("http");

        connector.setPort(8088);

        connector.setSecure(false);

        connector.setRedirectPort(65534);

        return connector;

    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {

            @Override

            protected void postProcessContext(Context context) {

                SecurityConstraint securityConstraint = new SecurityConstraint();

                securityConstraint.setUserConstraint("CONFIDENTIAL");

                SecurityCollection collection = new SecurityCollection();

                collection.addPattern("/*");

                securityConstraint.addCollection(collection);

                context.addConstraint(securityConstraint);

            }

        };

        tomcat.addAdditionalTomcatConnectors(connector());

        return tomcat;

    }

}
