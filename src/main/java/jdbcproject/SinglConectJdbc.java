package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Сonnecting to the database for JDBC module
 *
 */

public class SinglConectJdbc {

    private static Connection connection;

          static{
              try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/sai", "hrhr2", "hrhr");
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
