package com.phutl.service.impl;

import com.phutl.model.Category;
import com.phutl.repository.CategoryRepository;
import com.phutl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }

    @Override
    public boolean addOrUpdateCategory(Category p) {
        return this.categoryRepository.addOrUpdateCategory(p);
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        return this.categoryRepository.deleteCategory(categoryId);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return this.categoryRepository.getCategoryById(categoryId);
    }
}
