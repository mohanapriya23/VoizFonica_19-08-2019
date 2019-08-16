package com.example.voizfonica.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document
public class Edit{

    public FileCredentialsCache registerRepository;
    @Id
    private String id;

    @NotNull
    @Email(message = "Enter a valid email address")
    private String email;

    @NotNull
    @Size(min = 5,message = "Atleast 5 characters")
    private String password;

    private String name;
    private String phone;
    private String address;
    private String state;
    private String code;

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

/*    @Override
    public String toString() {
        return "Edit{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }*/

    public Edit(String id,String password, String email, String name, String phone, String address) {
        this.password =password;
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
