package com.example.voizfonica.data;

import com.example.voizfonica.model.PostpaidPlans;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlanRepository extends MongoRepository<PostpaidPlans,String>{
    List<PostpaidPlans> findByType(String type);

}
