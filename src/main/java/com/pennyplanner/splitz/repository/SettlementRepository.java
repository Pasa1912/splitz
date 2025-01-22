package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
}
