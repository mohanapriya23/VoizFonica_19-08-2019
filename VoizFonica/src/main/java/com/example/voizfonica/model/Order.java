package com.example.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document (collection = "order")
public class Order {
    @Id
    private String id;
    private String userid;
    private Payment payment;
    private String planId;
    private PostpaidPlans postpaidPlans;
    private Login login;
    private List<Register> register;
    private PaymentRecharge paymentRecharge;
    private Payment1 payment1;
    private Payment2 payment2;
    private DonglePurchase donglepurchase;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public PostpaidPlans getPostpaidPlans() {
        return postpaidPlans;
    }

    public void setPostpaidPlans(PostpaidPlans postpaidPlans) {
        this.postpaidPlans = postpaidPlans;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setRegister(List<Register> register) {
        this.register = register;
    }

    public void setPaymentRecharge(PaymentRecharge paymentRecharge) {
        this.paymentRecharge = paymentRecharge;
    }

    public void setPayment1(Payment1 payment1) {
        this.payment1 = payment1;
    }

    public void setDonglePurchase(DonglePurchase donglepurchase) {
        this.donglepurchase = donglepurchase;
    }

    public void setDongleId(String id) {
this.id=id;
    }
    public void setPayment2(Payment2 payment2) {
        this.payment2=payment2;
    }
}



