package com.app.ohmybooks.config;

import com.app.ohmybooks.config.property.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FlywayConfig {

    @Autowired
    private AppProperties appProperties;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            if(!appProperties.isMigration()){
                log.debug("FlywayConfig - Disabled migration");
                return;
            }
            log.debug("FlywayConfig - Starting migration");
            if (appProperties.isReinstall()){
                log.info("FlywayConfig - flyway.clean()");
                flyway.clean();
            }
            if(appProperties.isRepair()){
                log.info("FlywayConfig - flyway.repair()");
                flyway.repair();
            }
            flyway.migrate();
            log.debug("FlywayConfig - Ending migration");
        };
    }
}
