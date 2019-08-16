package com.example.voizfonica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Document
@Data
public class Register {
    @Id
    private String _id;

    @NotBlank(message = "Name is required")
    @Size(min = 5, message = "Enter a valid name")
    @Pattern(regexp = "[A-Za-z]*", message = "Enter a valid name")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 5, message = "Enter a valid password")
    private String password;

    @NotBlank(message = "Password is required")
    @Size(min = 5, message = "Enter a valid password")
    private String cpassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "email is mandatory")
    @Email(message = "Enter the correct mail")
    private String email;

    private String address;
    private String phone;
    private String state;
    private String code;
    private Order order;
    private NewConnection newConnection;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setNewConnection(NewConnection newConnection) {
        this.newConnection = newConnection;
    }
}
