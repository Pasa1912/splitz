package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
