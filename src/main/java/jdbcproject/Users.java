package jdbcproject;

import java.io.Serializable;

/**
*@autor VADIM NOVIKOV
* class Users- performing operations with users for JDBC module
*
* */

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String surname;
    String email;
    String address;


    public Users() {
    }

    public Users(String name,String surname,String email, String address) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
