package com.example.voizfonica.data;

import com.example.voizfonica.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface OrderRepository extends MongoRepository<Order,String> {

}
