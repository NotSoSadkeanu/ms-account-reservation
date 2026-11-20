package org.example.msaccountreservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.SourceType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "account_status")
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",
            nullable = false,
            unique = true,
            length = 50
    )
    private String name;

    @Column(name = "description",
            nullable = false,
            length = 255
    )
    private String description;

    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Builder
    public AccountStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}