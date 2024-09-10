package com.code.ecom.controller.admin;

import com.code.ecom.dto.CategoryDto;
import com.code.ecom.entity.Category;
import com.code.ecom.service.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

    @Autowired
    private final CategoryService categoryService;

    @PostMapping("category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
      Category category = categoryService.createCategory(categoryDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
