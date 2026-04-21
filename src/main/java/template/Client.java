package template;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import template.queryTemplate.MySQLQueryRunner;
import template.queryTemplate.QueryRunner;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder(TemplateConfiguration.class)
                .web(WebApplicationType.NONE)
                .run(args)) {
            QueryRunner<List<String>> queryRunner = context.getBean(MySQLQueryRunner.class);
            try {
                List<String> usernames = queryRunner.execute();
                System.out.println(usernames);
            } catch (java.sql.SQLException e) {
                System.err.println("Query failed: " + e.getMessage());
            }
        }
    }
}
