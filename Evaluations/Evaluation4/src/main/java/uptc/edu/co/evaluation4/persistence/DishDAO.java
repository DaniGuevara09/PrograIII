package uptc.edu.co.evaluation4.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import org.bson.Document;
import uptc.edu.co.evaluation4.logic.Dish;
import java.util.ArrayList;
import java.util.List;

public class DishDAO implements InterfaceDAO<Dish> {
    private final ConnectionString connectionString;

    public DishDAO() {
        String DRIVER = "mongodb+srv://jairoarmando:FvpyKzzDs4anFwMZ@cluster0.n99bjxu.mongodb.net";
        connectionString = new ConnectionString(DRIVER);
    }

    @Override
    public List<Dish> getAll() {
        ArrayList<Dish> dishes = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("your_database");
            MongoCollection<Document> collection = mongoDatabase.getCollection("dishes");

            FindIterable<Document> iterable = collection.find();

            for (Document doc : iterable) {
                Dish dish = new Dish();
                dish.setIdDish(doc.getString("idDish"));
                dish.setName(doc.getString("name"));
                dish.setCalories(doc.getInteger("calories"));
                dish.setVegetarian(doc.getBoolean("isVegetarian"));
                dish.setValue(doc.getInteger("value"));
                dish.setComments(doc.getString("comments"));
                dishes.add(dish);
            }
        }
        return dishes;
    }


    @Override
    public Dish findById(String idDish) {
        Dish dish = null;
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("your_database");
            MongoCollection<Document> collection = mongoDatabase.getCollection("dishes");

            Document query = new Document("idDish", idDish);
            Document doc = collection.find(query).first();

            if (doc != null) {
                dish = new Dish();
                dish.setIdDish(doc.getString("idDish"));
                dish.setName(doc.getString("name"));
                dish.setCalories(doc.getInteger("calories"));
                dish.setVegetarian(doc.getBoolean("isVegetarian"));
                dish.setValue(doc.getInteger("value"));
                dish.setComments(doc.getString("comments"));
            }
        }
        return dish;
    }

    @Override
    public Dish save(Dish dish) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("your_database");
            MongoCollection<Document> collection = mongoDatabase.getCollection("dishes");

            Document doc = new Document("idDish", dish.getIdDish())
                    .append("name", dish.getName())
                    .append("calories", dish.getCalories())
                    .append("isVegetarian", dish.isVegetarian())
                    .append("value", dish.getValue())
                    .append("comments", dish.getComments());

            collection.insertOne(doc);
        }
        return dish;
    }
}
