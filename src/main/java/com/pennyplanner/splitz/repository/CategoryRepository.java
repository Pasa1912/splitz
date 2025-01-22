package com.pennyplanner.splitz.repository;

import com.pennyplanner.splitz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
