package com.pennyplanner.splitz.service;

import com.pennyplanner.splitz.model.Category;
import com.pennyplanner.splitz.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository CategoryRepository;

    public Category createCategory(String name, String icon, String color) {
        Category category = new Category(name, icon, color);
        return CategoryRepository.save(category);
    }

    public Optional<Category> getCategoryById(Long id) {
        return CategoryRepository.findById(id);
    }

    public List<Category> getAllCategories() {
        return CategoryRepository.findAll();
    }

    public Category updateCategory(Long id, String name, String icon, String color) {
        Category category = CategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(name);
        category.setIcon(icon);
        category.setColor(color);

        return CategoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        if (!CategoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        CategoryRepository.deleteById(id);
    }
}
