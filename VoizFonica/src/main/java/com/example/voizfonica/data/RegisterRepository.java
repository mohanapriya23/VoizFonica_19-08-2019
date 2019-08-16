package com.example.voizfonica.data;


import com.example.voizfonica.model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegisterRepository extends MongoRepository<Register, String> {

    List<Register> findByEmailAndAndPassword(String email, String password);
    Register findByEmail(String email);
}
