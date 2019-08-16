package com.example.voizfonica.data;

import com.example.voizfonica.model.DonglePurchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DongleRepository extends MongoRepository<DonglePurchase,String> {

}
