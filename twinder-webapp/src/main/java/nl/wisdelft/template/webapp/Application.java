package nl.wisdelft.template.webapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 * The @ComponentScan annotation tells Spring to search recursively through the 
 * current(?) package and its children for classes marked directly or indirectly 
 * with Spring’s @Component annotation (Controller included).
 * This directive ensures that Spring finds and registers the GreetingController, 
 * because it is marked with @Controller, which in turn is a kind of @Component 
 * annotation.
 * 
 * The @EnableAutoConfiguration annotation switches on reasonable default 
 * behaviors based on the content of your classpath.
 * the application depends on the embeddable version of Tomcat 
 * (tomcat-embed-core.jar), a Tomcat server is set up and configured with 
 * reasonable defaults on your behalf.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application
{
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
//        SpringApplication.run(MongoExample.class, args);
    }
}
