package com.kodilla.rentacamperbackend.mapper;

import com.kodilla.rentacamperbackend.domain.Category;
import com.kodilla.rentacamperbackend.domain.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category mapToCategory(final CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getDescription(),
                categoryDto.getEngineCapacity(),
                categoryDto.getEngineType(),
                categoryDto.getCamperList());
    }

    public CategoryDto mapToCategoryDto(final Category category) {
        return new CategoryDto.CategoryDtoBuilder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .engineCapacity(category.getEngineCapacity())
                .engineType(category.getEngineType())
                .camperList(category.getCamperList())
                .build();
    }

    public List<CategoryDto> mapToCategoryDtoList(final List<Category> categoryList) {
        return categoryList.stream()
                .map(t -> new CategoryDto(t.getId(), t.getName(), t.getDescription(), t.getEngineCapacity(),
                        t.getEngineType(), t.getCamperList()))
                .collect(Collectors.toList());
    }
}
