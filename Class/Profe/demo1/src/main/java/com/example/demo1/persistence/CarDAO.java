package com.example.demo1.persistence;

import com.example.demo1.logic.Car;
import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import org.bson.Document;

import java.io.IOException;
import java.util.List;

public class CarDAO implements InterfaceDAO<Car>{
    private ConnectionString connectionString;
    private final String DRIVER = "mongodb://127.0.0.1:27017";

    public CarDAO() {
        connectionString = new ConnectionString(DRIVER);
    }

    @Override
    public List<Car> getAll() {
        try(
                MongoClient mongoClient = MongoClients.create(connectionString)
                ){
            MongoDatabase mongoDatabase = mongoClient.getDatabase("cars");
            MongoCollection<Document> collection = mongoDatabase.getCollection("cars");

            FindIterable it = collection.find();

            it.forEach( System.out::println);
        }

        return null;
    }

    @Override
    public Car findById(Integer id) {
        return null;
    }

    @Override
    public Car save(Car object) {
        return null;
    }

    @Override
    public Car Delete(Integer id) {
        return null;
    }

    @Override
    public Car update(Integer id, Car object) {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
