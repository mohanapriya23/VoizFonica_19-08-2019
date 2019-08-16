package com.example.voizfonica.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@RequiredArgsConstructor
@Data
@Document
public class PaymentRecharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull
    @Digits(integer=10,message="Invalid number", fraction = 0)
    private String mobileno;

    @NotNull
    @Pattern(regexp = "[0-9]*", message = "Enter a valid amount")
    @Size(min=3,message="Too low to make a transaction")
    @Size(max = 5, message = "You have exceeded the transaction ceiling ")
    private String amount;
}
