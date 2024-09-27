package org.example.springconfigserverclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class SpringConfigserverClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigserverClientApplication.class, args);
    }
  @Bean
      public CommandLineRunner commandLineRunner(Environment environment) {
          return args -> {
              System.out.println("============ display all configuration property sources: ===========================================");
              MutablePropertySources propSrcs = ((AbstractEnvironment) environment).getPropertySources();
              propSrcs.stream().spliterator().forEachRemaining(propertySource ->
              {   System.out.println("------" + propertySource.getName());
                  if (propertySource instanceof EnumerablePropertySource && !propertySource.getName().contains("systemProperties") && !propertySource.getName().contains("systemEnvironment")) {
                      EnumerablePropertySource enumerablePropertySource = (EnumerablePropertySource) propertySource;
                      Arrays.stream(enumerablePropertySource.getPropertyNames())
                              .forEach(propName -> {System.out.println(propName + " = " + environment.getProperty(propName));});
                  }

              });


          };
      }
}
