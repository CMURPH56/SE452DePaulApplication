package edu.depaul.cdm.se.SpaceApplication;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class MongoHandler {

    public static void main(String args[]){
        try{
            MongoClientURI uri = new MongoClientURI("mongodb://user:password*1@ds235788.mlab.com:35788/mydb");
            MongoClient mongoClient = new MongoClient(uri);
            //System.out.println("Cam");
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("test");

            List<Document> documents = new ArrayList<Document>();

            Document mercury  = new Document("Planet", "Mercury")
                                .append("Description", "Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System. It is named after the Roman deity Mercury, the messenger of the gods.");
            documents.add(mercury);
            Document mars  = new Document("Planet", "Mars")
                    .append("Description", "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. ");
            documents.add(mars);
            Document venus  = new Document("Planet", "Venus")
                    .append("Description", "Venus is the second planet from the Sun, orbiting it every 224.7 Earth days. It has the longest rotation period of any planet in the Solar System and rotates in the opposite direction to most other planets. It does not have any natural satellites. It is named after the Roman goddess of love and beauty.");
            documents.add(venus);
            Document jupiter  = new Document("Planet", "Jupiter")
                    .append("Description", "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a giant planet with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined.");
            documents.add(jupiter);
            Document saturn  = new Document("Planet", "Saturn")
                    .append("Description", "Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter. It is a gas giant with an average radius about nine times that of Earth. It has only one-eighth the average density of Earth, but with its larger volume Saturn is over 95 times more massive.");
            documents.add(saturn);
            Document pluto  = new Document("Planet", "Pluto")
                    .append("Description", "Pluto is a dwarf planet in the Kuiper belt, a ring of bodies beyond Neptune. It was the first Kuiper belt object to be discovered. Pluto was discovered by Clyde Tombaugh in 1930 and was originally considered to be the ninth planet from the Sun.");
            documents.add(pluto);
            Document neptune = new Document("Planet", "Neptune")
                    .append("Description", "Neptune is the eighth and farthest known planet from the Sun in the Solar System. In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet, and the densest giant planet.");
            documents.add(neptune);
            Document uranus = new Document("Planet", "Uranus")
                    .append("Description", "Uranus is the seventh planet from the Sun. It has the third-largest planetary radius and fourth-largest planetary mass in the Solar System. Uranus is similar in composition to Neptune, and both have bulk chemical compositions which differ from that of the larger gas giants Jupiter and Saturn.");
            documents.add(uranus);


            Document myDoc = collection.find(eq("Planet", "Pluto")).first();
            System.out.println(myDoc.toJson());

            JSONObject jdoc = new JSONObject(myDoc.toJson());

            String name = jdoc.getString("Planet");
            System.out.println(name);

            System.out.println("left "+ collection.count());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
