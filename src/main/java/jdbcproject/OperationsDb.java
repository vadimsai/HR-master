package jdbcproject;

import jtaproject.DBOperations;
import jtaproject.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


/**
 *@autor VADIM NOVIKOV
 *
 * class OperationsDb-  implementation of database access methods for JDBC module
 *
 */

public class OperationsDb implements DBOperations {

    @Override
    public String insert( Users users){
        if(!(users.getName().equals("")||users.getSurname().equals(""))) {
            Connection connection = SinglConectJdbc.Con();
            try {
                PreparedStatement prstatement = connection.prepareStatement("insert into sai.Users (name,surname,email,address) values(?,?,?,?)");
                prstatement.setString(1, users.getName());
                prstatement.setString(2, users.getSurname());
                prstatement.setString(3, users.getEmail());
                prstatement.setString(4, users.getAddress());
                prstatement.execute();
                prstatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {return "the name and surname field is required";}
        return "user insert";
    }


    @Override
    public String remove(int id)  {
        Connection connection = SinglConectJdbc.Con();
        try {
            PreparedStatement prstatement = connection.prepareStatement("delete from sai.Users where id=?");
            prstatement.setInt(1, id);
            prstatement.executeUpdate();
            prstatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "user delete";
    }


    @Override
    public String update(int id,Users users){
        if(!(users.getName().equals("")||users.getSurname().equals(""))) {
            Connection connection = SinglConectJdbc.Con();
            try {
                PreparedStatement prstatement = connection.prepareStatement("update sai.Users SET name =? , surname=?, email=?,address=?  where id=?");
                prstatement.setString(1, users.getName());
                prstatement.setString(2, users.getSurname());
                prstatement.setString(3, users.getEmail());
                prstatement.setString(4, users.getAddress());
                prstatement.setInt(5, id);
                prstatement.executeUpdate();
                prstatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {return "the name and surname field is required";}
        return "user update";
    }




    @Override
    public List<Users> selectAll()  {
        List<Users> list=new ArrayList<>();
        Connection connection = SinglConectJdbc.Con();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from sai.Users");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Users users=new Users();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setSurname(resultSet.getString("surname"));
                users.setEmail(resultSet.getString("email"));
                users.setAddress(resultSet.getString("address"));
                list.add(users);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    @Override
    public List<Users> getById(int id) {
        List<Users> list =new ArrayList<>();
        Connection connection = SinglConectJdbc.Con();
       try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from sai.Users where id=?");  // защита от инъекций
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Users users=new Users();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setSurname(resultSet.getString("surname"));
                users.setEmail(resultSet.getString("email"));
                users.setAddress(resultSet.getString("address"));
                list.add(users);
            }
           resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
