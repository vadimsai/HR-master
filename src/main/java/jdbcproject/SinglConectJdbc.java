package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *@autor VADIM NOVIKOV
 * Сonnecting to the database for JDBC module
 *
 */

public class SinglConectJdbc {

    private static Connection connection;

          static{
              try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection= DriverManager.getConnection("jdbc:mysql://sai.c6mijjstehsi.us-east-2.rds.amazonaws.com:3306/sai",  "admin","170684vad" );
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }

          }

    public  static Connection Con(){
        return connection;
    }
}
