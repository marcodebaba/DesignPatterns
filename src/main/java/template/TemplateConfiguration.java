package template;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import template.mytemplate.MySQLQueryRunner;

import java.util.Properties;

@Configuration
public class TemplateConfiguration {

    @Bean
    public DatabaseConfig databaseConfig() {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application.yml"));
        Properties properties = factoryBean.getObject();
        Properties safeProperties = properties != null ? properties : new Properties();

        return new DatabaseConfig(
                safeProperties.getProperty("spring.datasource.driver-class-name"),
                safeProperties.getProperty("spring.datasource.url"),
                safeProperties.getProperty("spring.datasource.username"),
                safeProperties.getProperty("spring.datasource.password")
        );
    }

    @Bean
    public MySQLQueryRunner mySQLQueryRunner(DatabaseConfig databaseConfig) {
        return new MySQLQueryRunner(databaseConfig);
    }
}
