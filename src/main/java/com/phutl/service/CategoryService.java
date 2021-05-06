package com.phutl.service;

import com.phutl.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    boolean addOrUpdateCategory(Category p);
    boolean deleteCategory(int categoryId);
    Category getCategoryById(int categoryId);
}
