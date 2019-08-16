package com.example.voizfonica.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
@RequiredArgsConstructor
@Document (collection="postpaidplans")

public class PostpaidPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private  String currency;
    private String planName;
    private String valid;
    private String amount;
    private String totalData;
    private String speed;
    private String validity;
    private String type;
    public PostpaidPlans(String type,String currency, String planName, String valid, String amount, String totalData, String speed, String validity) {
        this.currency = currency;
        this.planName = planName;
        this.valid = valid;
        this.amount = amount;
        this.totalData = totalData;
        this.speed = speed;
        this.validity = validity;
        this.type = type;
    }
}
