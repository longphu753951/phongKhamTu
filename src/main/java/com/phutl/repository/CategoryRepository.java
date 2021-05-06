package com.phutl.repository;

import com.phutl.model.Category;


import java.util.List;

public interface CategoryRepository {
    List<Category> getCategories();
    boolean addOrUpdateCategory(Category p);
    boolean deleteCategory(int categoryId);
    Category getCategoryById(int categoryId);
}
