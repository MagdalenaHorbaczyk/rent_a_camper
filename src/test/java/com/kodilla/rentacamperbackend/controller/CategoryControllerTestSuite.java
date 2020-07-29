package com.kodilla.rentacamperbackend.controller;

import com.google.gson.Gson;
import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CategoryDto;
import com.kodilla.rentacamperbackend.mapper.CategoryMapper;
import com.kodilla.rentacamperbackend.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTestSuite {

    @MockBean
    CategoryService categoryService;
    @MockBean
    CategoryMapper categoryMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetCategories() throws Exception {
        //Given
        List<Category> categoriesList = new ArrayList<>();
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        categoriesList.add(category);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto categoryDto = new CategoryDto(1L, "Dto luxury", "Dto category test",
                "Dto engineCapacity test", "Dto engineType test", new ArrayList());
        categoryDtoList.add(categoryDto);
        when(categoryService.findAllCategories()).thenReturn(categoriesList);
        when(categoryMapper.mapToCategoryDtoList(categoriesList)).thenReturn(categoryDtoList);
        //When & Then
        mockMvc.perform(get("/v1/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Dto luxury")))
                .andExpect(jsonPath("$[0].description", is("Dto category test")));
    }

    @Test
    public void testGetCategory() throws Exception {
        //Given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        CategoryDto categoryDto = new CategoryDto(1L, "Dto luxury", "Dto category test",
                "Dto engineCapacity test", "Dto engineType test", new ArrayList());
        when(categoryService.getCategory(category.getId())).thenReturn(Optional.ofNullable(category));
        when(categoryMapper.mapToCategoryDto(any(Category.class))).thenReturn(categoryDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(categoryDto);
        //When & Then
        mockMvc.perform(get("/v1/categories/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.engineCapacity", is("Dto engineCapacity test")))
                .andExpect(jsonPath("$.engineType", is("Dto engineType test")));
    }

    @Test
    public void shouldUpdateCategory() throws Exception {
        //Given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        CategoryDto categoryDto = new CategoryDto(1L, "Dto luxury", "Dto category test",
                "Dto engineCapacity test", "Dto engineType test", new ArrayList());
        when(categoryMapper.mapToCategoryDto(category)).thenReturn(categoryDto);
        when(categoryMapper.mapToCategory(any(CategoryDto.class))).thenReturn(category);
        when(categoryService.saveCategory(category)).thenReturn(category);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(category);
        //When & Then
        mockMvc.perform(put("/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.engineCapacity", is("Dto engineCapacity test")))
                .andExpect(jsonPath("$.engineType", is("Dto engineType test")));
    }

    @Test
    public void shouldCreateCategory() throws Exception {
        //Given
        Category category = new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
        CategoryDto categoryDto = new CategoryDto(1L, "Dto luxury", "Dto category test",
                "Dto engineCapacity test", "Dto engineType test", new ArrayList());
        when(categoryMapper.mapToCategoryDto(category)).thenReturn(categoryDto);
        when(categoryMapper.mapToCategory(any(CategoryDto.class))).thenReturn(category);
        when(categoryService.saveCategory(category)).thenReturn(category);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(category);
        //When & Then
        mockMvc.perform(post("/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}




