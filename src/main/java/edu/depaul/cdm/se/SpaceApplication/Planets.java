package edu.depaul.cdm.se.SpaceApplication;
import org.springframework.data.annotation.Id;
import java.util.Random;

public class Planets {


    private Long id;
    private String Planet;
    private String Description;

    public Planets() {
        id = new Random().nextLong();
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getPlanet(){
        return Planet;
    }
    public void setPlanet(String planet){
        this.Planet = planet;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String description){
        this.Description = description;
    }
    @Override
    public String toString(){
        System.out.println("hello");
        return String.format(
                "Planet[name=%s, description=%s]",
                Planet, Description);
    }

}