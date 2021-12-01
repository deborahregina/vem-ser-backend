import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        MongoCredential credential = MongoCredential.createCredential( "root", "admin", "root".toCharArray());
        MongoClient cliente = new MongoClient(new ServerAddress("localhost", 27017) , Arrays.asList(credential));
        MongoDatabase db = cliente.getDatabase("restauranteapi");
        MongoCollection<Document> contatos = db.getCollection("contatos");


        Document novoAluno = new Document("nome", "Ana")
                .append("data_nascimento", new Date(2000, 10, 10))
                .append("curso", new Document("nome", "Matemática"))
                .append("notas", Arrays.asList(8,7,9))
                .append("habilidades", Arrays.asList( new Document()
                                .append("nome", "Português")
                                .append("nível", "Fluente"),
                        new Document()
                                .append("nome", "Inglês")
                                .append("nível", "Intermediário")));

        contatos.insertOne(novoAluno);


        FindIterable<Document> result = contatos.find();
        result.forEach((Block<? super Document>) d -> System.out.println(d.toJson()));

        //update
        contatos.updateOne(Filters.eq("nome", "Valéria"), Updates.set("nome", "Adriele"));

        //delete:
        contatos.deleteOne(Filters.eq("_id", 2));

        cliente.close();
    }
}
