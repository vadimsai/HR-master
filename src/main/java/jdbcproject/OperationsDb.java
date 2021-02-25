package jdbcproject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class OperationsDb implements DbJdbcOperations{
    private final static String user = "hrhr2";
    private final String password = "hrhr";
    private final String conect = "jdbc:mysql://localhost:3306/sai";

    @Override
    public String insertDB(String name, String surname, String birthDate, String address){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            PreparedStatement prstatement = connection.prepareStatement("insert into userjdbc (name_user,surname,birth_date,address) values(?,?,?,?)");
            prstatement.setString(1, name);
            prstatement.setString(2, surname);
            prstatement.setString(3, birthDate);
            prstatement.setString(4, address);
            prstatement.execute();
            prstatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "jr";
    }

    @Override
    public String deleteDB(int id)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            PreparedStatement prstatement = connection.prepareStatement("delete from userjd where id=?");
            prstatement.setInt(1, id);
            prstatement.executeUpdate();
            prstatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public String updateDB(int id, String name, String surname, String email, String address){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            PreparedStatement prstatement = connection.prepareStatement("update userjd SET name_user =? , surname=?, email=?,address=?  where id=?");
            prstatement.setString(1, name);
            prstatement.setString(2, surname);
            prstatement.setString(3, email);
            prstatement.setString(4, address);
            prstatement.setInt(5, id);
            prstatement.executeUpdate();
            prstatement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<String> getById(int id) {
        List<String> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            PreparedStatement preparedStatement=connection.prepareStatement("select * from userjd where id=?");  // защита от инъекций
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                list.add(String.valueOf(resultSet.getString("surname")));
                list.add(resultSet.getString("name_user"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }


    @Override
    public List<String> getAll()  {
        List<String> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from userjd");
            while (resultSet.next())
            {
                list.add(resultSet.getString("surname"));
                list.add(resultSet.getString("name_user"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public List<UserJdbc> getall(int id) {
        List<UserJdbc> list =new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(conect, user, password);
            PreparedStatement preparedStatement=connection.prepareStatement("select * from userjd where id=?");  // защита от инъекций
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                UserJdbc userJdbc=new UserJdbc();
                userJdbc.setId(resultSet.getInt("id"));
                userJdbc.setName_user(resultSet.getString("name_user"));
                userJdbc.setSurname(resultSet.getString("surname"));
                userJdbc.setEmail(resultSet.getString("email"));
                userJdbc.setAddress(resultSet.getString("address"));
                list.add(userJdbc);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


}
