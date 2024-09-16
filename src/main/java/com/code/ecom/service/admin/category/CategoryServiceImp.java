package com.code.ecom.service.admin.category;

import com.code.ecom.dto.CategoryDto;
import com.code.ecom.entity.Category;
import com.code.ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {


    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);

    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
