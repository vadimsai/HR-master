package jdbcproject;

import java.io.Serializable;

public class UserJdbc implements Serializable {

    int id;
    String name_user;
    String surname;
    String email;
    String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserJdbc(String name_user, String surname, String email, String address) {
       super();
        this.name_user = name_user;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public UserJdbc() {
        super();
    }
}
