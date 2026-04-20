package template;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import template.queryTemplate.MySQLQueryRunner;
import template.queryTemplate.QueryRunner;

import java.util.List;

/**
 * Created by marcopan on 17/9/26.
 */
public class Client {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(TemplateConfiguration.class)) {
            QueryRunner<List<String>> queryRunner = context.getBean(MySQLQueryRunner.class);
            try {
                List<String> usernames = queryRunner.execute();
                System.out.println(usernames);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
