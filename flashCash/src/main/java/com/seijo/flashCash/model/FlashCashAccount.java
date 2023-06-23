package com.seijo.flashCash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FlashCashAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalAmount;
    private Double flashCashAmount;

    public FlashCashAccount() {
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setFlashCashAmount(Double flashCashAmount) {
        this.flashCashAmount = flashCashAmount;
    }

    public Integer getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getFlashCashAmount() {
        return flashCashAmount;
    }
}
