package com.app.ohmybooks;

import com.app.ohmybooks.config.property.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
@EnableJpaRepositories
@EnableSwagger2
public class OhmybooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhmybooksApplication.class, args);
    }

}
