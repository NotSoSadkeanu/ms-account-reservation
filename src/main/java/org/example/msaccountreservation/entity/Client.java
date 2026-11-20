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
@Table(name = "client")
public class Client {
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

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "client_type")
    private String clientType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_series")
    private String documentSeries;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "mdm_code")
    private Long mdmCode;

    @Builder
    public Client(String fullName, String citizenship, String clientType, String documentNumber, String documentSeries, String documentType, Long mdmCode) {
        this.fullName = fullName;
        this.citizenship = citizenship;
        this.clientType = clientType;
        this.documentNumber = documentNumber;
        this.documentSeries = documentSeries;
        this.documentType = documentType;
        this.mdmCode = mdmCode;
    }
}
