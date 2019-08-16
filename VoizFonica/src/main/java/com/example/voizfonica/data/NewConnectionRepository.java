package com.example.voizfonica.data;


import com.example.voizfonica.model.NewConnection;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface NewConnectionRepository extends MongoRepository <NewConnection,String>
{

}
