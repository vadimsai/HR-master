package jdbcproject;

import java.sql.*;
import java.util.List;

public class Jdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        OperationsDb operationsDb=new OperationsDb();
        operationsDb.insertDB("SAI555", "AUM99999", "SAI111", "AUM333");
        operationsDb.deleteDB(5);
        operationsDb.updateDB(3,"SAI77777", "AUM99999", "SAI111", "AUM333");
        List<String> list=operationsDb.getById(9);

        for(String e:list)
        {
            System.out.println(e);
        }
      //  operationsDb.getAll();


     /*   String user = "hr";
        String password = "hr";
        String conect = "jdbc:oracle:thin:@localhost:1521:XE";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(conect, user, password);
        Statement statement = connection.createStatement();

        statement.executeUpdate("drop table students");
        statement.executeUpdate("CREATE TABLE students(id integer NOT NULL ,name VARCHAR(30) NOT NULL, age INTEGER ,PRIMARY KEY (id))");
        statement.executeUpdate("insert into students  values (5,'Babadgi',999)");
        statement.executeUpdate("insert into students  values (6,'AUM',777)");

        ResultSet resultSet = statement.executeQuery("select*from students");
        String n = null;
        String a = null;
        while (resultSet.next()) {
            n = resultSet.getString("name");
            a = resultSet.getString("age");
        }
        System.out.println(n+" "+a);*/

    }
}
