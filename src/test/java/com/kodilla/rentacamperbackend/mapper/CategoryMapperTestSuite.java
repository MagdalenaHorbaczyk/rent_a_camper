package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CategoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTestSuite {

    @Autowired
    private CategoryMapper categoryMapper;

    private Category createCategory() {
        return new Category(1L, "luxury", "category test",
                "engineCapacity test", "engineType test", new ArrayList());
    }

    private CategoryDto createCategoryDto() {
        return new CategoryDto(1L, "Dto luxury", "Dto category test",
                "Dto engineCapacity test", "Dto engineType test", new ArrayList());
    }

    @Test
    public void testMapToCategory() {
        //Given
        CategoryDto categoryDto = createCategoryDto();
        //When
        Category category = categoryMapper.mapToCategory(categoryDto);
        //Then
        assertNotNull(category);
        assertEquals(Long.valueOf(1), category.getId());
        assertEquals("Dto luxury", category.getName());
    }

    @Test
    public void testMapToCategoryDto() {
        //Given
        Category category = createCategory();
        //When
        CategoryDto categoryDto = categoryMapper.mapToCategoryDto(category);
        //Then
        assertNotNull(category);
        assertEquals(Long.valueOf(1), category.getId());
        assertEquals("luxury", categoryDto.getName());
    }

    @Test
    public void testMapToCategoryDtoList() {
        //Given
        Category category = createCategory();
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        //When
        List<CategoryDto> categoryDtoList = categoryMapper.mapToCategoryDtoList(categoryList);
        //Then
        assertNotNull(categoryDtoList);
        assertEquals(1, categoryDtoList.size());
    }
}
