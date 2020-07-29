package com.kodilla.rentacamperbackend.controller;

import com.kodilla.rentacamperbackend.domain.dto.CategoryDto;
import com.kodilla.rentacamperbackend.exception.CategoryNotFoundException;
import com.kodilla.rentacamperbackend.mapper.CategoryMapper;
import com.kodilla.rentacamperbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/categories")
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "")
    public List<CategoryDto> getCategories() {
        return categoryMapper.mapToCategoryDtoList((categoryService.findAllCategories()));
    }

    @GetMapping(value = "/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId) throws CategoryNotFoundException {
        return categoryMapper.mapToCategoryDto(categoryService.getCategory(categoryId).orElseThrow(CategoryNotFoundException::new));
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public void createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.saveCategory(categoryMapper.mapToCategory(categoryDto));
    }

    @PutMapping(value = "", consumes = APPLICATION_JSON_VALUE)
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryMapper.mapToCategoryDto(categoryService.saveCategory(categoryMapper.mapToCategory(categoryDto)));
    }

    @DeleteMapping(value = "/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
