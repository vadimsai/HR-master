package jtaproject;




import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@DataSourceDefinitions(
        @DataSourceDefinition( name ="Definition", user="hrhr2",
                password = "hrhr", url ="jdbc:mysql://localhost:3306/sai",
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

    // @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    String birthDate;


    @Column(name = "address")
    String address;



    public Users() {
    }

    public Users(String name,String surname,String birthDate, String address) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
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


    public String getBirthDate() {
        return birthDate;
    }
    @XmlElement
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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