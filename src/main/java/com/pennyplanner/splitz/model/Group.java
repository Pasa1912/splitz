package com.pennyplanner.splitz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private Boolean simplifyDebts;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Group(String name, Long createdBy, Boolean simplifyDebts) {
        this.name = name;
        this.createdBy = createdBy;
        this.simplifyDebts = simplifyDebts;
        this.createdAt = LocalDateTime.now();
    }
}
