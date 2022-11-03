package com.htboard.service;

import com.htboard.dto.Category;
import com.htboard.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    public List<Category> findByBoardCategoryId(int categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    public List<Category> findByBoardCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
