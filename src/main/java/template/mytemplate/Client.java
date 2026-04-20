package template.mytemplate;

import java.util.List;

/**
 * Created by marcopan on 17/9/26.
 */
public class Client {
    public static void main(String[] args) {
        QueryRunner<List<String>> queryRunner = new MySQLQueryRunner();
        try {
            List<String> usernames = queryRunner.run();
            System.out.println(usernames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
