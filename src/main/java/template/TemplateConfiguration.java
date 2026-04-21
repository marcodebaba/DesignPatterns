package template;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import template.queryTemplate.MySQLQueryRunner;

@Configuration
@EnableConfigurationProperties(MySQLDatabaseConfig.class)
public class TemplateConfiguration {

    @Bean
    public MySQLQueryRunner mySQLQueryRunner(MySQLDatabaseConfig databaseConfig) {
        return new MySQLQueryRunner(databaseConfig);
    }
}
