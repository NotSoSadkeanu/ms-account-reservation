package org.example.msaccountreservation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "account_type", nullable = false, length = 255)
    private String accountType;

    @Column(name = "currency_code", nullable = false, length = 255)
    private String currencyCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private AccountStatus status;

    @Builder
    public Account(String accountType, String currencyCode, Client client, AccountStatus status) {
        this.accountType = accountType;
        this.currencyCode = currencyCode;
        this.client = client;
        this.status = status;
    }
}