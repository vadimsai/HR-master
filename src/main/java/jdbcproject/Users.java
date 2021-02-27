package jdbcproject;

import java.io.Serializable;

public class Users implements Serializable {

    int id;
    String name;
    String surname;
    String birthDate;
    String address;


    public Users() {
    }

    public Users(String name,String surname,String birthDate, String address) {
        super();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
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


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
