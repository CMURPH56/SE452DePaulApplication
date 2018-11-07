package edu.depaul.cdm.se.SpaceApplication;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
//@Table(name = "members")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}