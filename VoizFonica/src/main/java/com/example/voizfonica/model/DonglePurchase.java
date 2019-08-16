package com.example.voizfonica.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@Document(collection = "donglePurchase")

public class DonglePurchase {



    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDongleName() {
        return dongleName;
    }

    public void setDongleName(String dongleName) {
        this.dongleName = dongleName;
    }

    public String getDongleId() {
        return dongleId;
    }

    public void setDongleId(String dongleId) {
        this.dongleId = dongleId;
    }

    @Id
    private String dongleId;
    private  String amount;
    private String dongleName;

    public DonglePurchase(String dongleName,String amount){
        this.dongleName = dongleName;
        this.amount = amount;
    }
}
