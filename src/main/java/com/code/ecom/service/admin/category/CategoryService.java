package com.code.ecom.service.admin.category;

import com.code.ecom.dto.CategoryDto;
import com.code.ecom.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);

    List<Category> getAllCategories();
}
