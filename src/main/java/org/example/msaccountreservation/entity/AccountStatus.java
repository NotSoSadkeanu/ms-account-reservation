package org.example.msaccountreservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "account_status")
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(
            name = "name",
            nullable = false,
            unique = true,
            length = 50
    )
    private String name;
    @Column(
            name = "description",
            nullable = false,
            length = 255
    )
    private String description;

    public AccountStatus() {

    }
    public AccountStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}