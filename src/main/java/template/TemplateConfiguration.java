package template;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import template.queryTemplate.MySQLQueryRunner;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class TemplateConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource mysqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public MySQLQueryRunner mySQLQueryRunner(@Qualifier("mysqlDataSource") DataSource dataSource) {
        return new MySQLQueryRunner(dataSource, "select name from user");
    }
}
