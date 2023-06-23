package com.seijo.flashCash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne
    private User fromUser;
    @ManyToOne
    private User toUser;
    private Double amountBeforeTransfer;
    private Double amountAfterTransfer;
    private Double commissionPercentage;


    public Transfer() {
    }

    public void setAmountBeforeTransfer(Double amountBeforeTransfer) {
        this.amountBeforeTransfer = amountBeforeTransfer;
    }

    public void setAmountAfterTransfer(Double amountAfterTransfer) {
        this.amountAfterTransfer = amountAfterTransfer;
    }

    public void setCommissionPercentage(Double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Double getAmountBeforeTransfer() {
        return amountBeforeTransfer;
    }

    public Double getAmountAfterTransfer() {
        return amountAfterTransfer;
    }

    public Double getCommissionPercentage() {
        return commissionPercentage;
    }
}
