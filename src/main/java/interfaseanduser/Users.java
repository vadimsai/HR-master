package interfaseanduser;




import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@autor VADIM NOVIKOV
 * class Users- create table for all modules and
 * @XmlRootElement @return in XML format for restful service module
 */

@DataSourceDefinitions(
        @DataSourceDefinition(name ="Definition", user="admin",
                password = "170684vad", url ="jdbc:mysql://sai.c6mijjstehsi.us-east-2.rds.amazonaws.com:3306/sai",
                className = "com.mysql.cj.jdbc.Driver"))

@XmlRootElement
@Entity
@Table(name = "Users")
@Access(AccessType.FIELD)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "surname", nullable = false)
    String surname;


    @Column(name = "email")
    String email;


    @Column(name = "address")
    String address;



    public Users() {
    }

    public Users(String name,String surname,String email, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }


    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }
    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getName() {
        return  name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }



}