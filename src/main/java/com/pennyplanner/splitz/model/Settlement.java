package com.pennyplanner.splitz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "settlements")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payer_id", nullable = false)
    private User payer;

    @ManyToOne
    @JoinColumn(name = "payee_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "settlement_date", nullable = false)
    private LocalDateTime settlementDate;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Settlement(User payer, User user, Double amount, String currencyCode, String settlementDate, String paymentMethod){
        this.payer = payer;
        this.user = user;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.settlementDate = LocalDateTime.parse(settlementDate);
        this.paymentMethod = paymentMethod;
        this.createdAt = LocalDateTime.now();
    }
}

