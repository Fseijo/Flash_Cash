package com.seijo.flashCash.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;
    private String iban;


    public UserAccount plus(double amount){
        this.amount += amount;
        return this;
    }
    public UserAccount minus(double amount){
        this.amount -= amount;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
