package com.snort.repository;

import com.snort.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product,String > {
}
