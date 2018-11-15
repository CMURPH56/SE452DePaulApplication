package edu.depaul.cdm.se.SpaceApplication;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "Members")
public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    public String getPassword(){return password;}

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Members)){
            return false;
        }
        Members other = (Members) object;
        if((this.id == null && other.id != null) || (this.id != null && this.id.equals(other.id))){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder retval = new StringBuilder();
        retval.append("Member{");
        retval.append("id=");
        retval.append(id);
        retval.append(", email=");
        retval.append(email);
        return retval.toString();
    }
}