package com.example.voizfonica.data;

import com.example.voizfonica.model.PaymentRecharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRechargeRepository extends MongoRepository<PaymentRecharge, String> {
}
