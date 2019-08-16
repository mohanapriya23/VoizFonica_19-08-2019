package com.example.voizfonica.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data


@RequiredArgsConstructor

@Document (collection="dongleplan")

public class DonglePlan {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private  String currency;
    private String planName;
    private String valid;
    private   String amount;
    private String totalData;
    private String speed;
    private String validity;

    public DonglePlan(String currency, String planName, String valid, String amount, String totalData, String speed, String validity) {
        this.currency = currency;
        this.planName = planName;
        this.valid = valid;
        this.amount = amount;
        this.totalData = totalData;
        this.speed = speed;
        this.validity = validity;
    }


}
