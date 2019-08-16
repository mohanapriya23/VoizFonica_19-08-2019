package com.example.voizfonica.data;

import com.example.voizfonica.model.DonglePlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonglePlanRepository extends MongoRepository<DonglePlan,String>{

}