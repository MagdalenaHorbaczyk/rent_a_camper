package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTestSuite {

    @InjectMocks
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @Test
    public void getAllCategoriesTest() {
        //when
        categoryService.findAllCategories();
        //then
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void getCategoryTest() {
        //given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        //when
        categoryService.getCategory(category.getId());
        //then
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    public void saveCategoryTest() {
        //given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        //when
        categoryService.saveCategory(category);
        //then
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    public void deleteCategoryTest() {
        //given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        //when
        categoryService.deleteCategory(category.getId());
        //then
        verify(categoryRepository, times(1)).deleteById(1L);
    }
}

