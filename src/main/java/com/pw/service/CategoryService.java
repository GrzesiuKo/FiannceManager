package com.pw.service;

import com.pw.model.Category;
import com.pw.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(String category) {
        categoryRepository.addCategory(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteCategory(id);
    }


    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }
}
