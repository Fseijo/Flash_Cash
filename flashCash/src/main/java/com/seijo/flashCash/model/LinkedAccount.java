package com.seijo.flashCash.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LinkedAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;

    public LinkedAccount() {
    }

    public Integer getId() {
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }
}
