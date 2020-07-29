package com.kodilla.rentacamperbackend.domain.dto;

import com.kodilla.rentacamperbackend.domain.Camper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private String engineCapacity;
    private String engineType;
    private List<Camper> camperList = new ArrayList();

    public static class CategoryDtoBuilder {
        private Long id;
        private String name;
        private String description;
        private String engineCapacity;
        private String engineType;
        private List<Camper> camperList = new ArrayList();

        public CategoryDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryDtoBuilder engineCapacity(String engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public CategoryDtoBuilder engineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CategoryDtoBuilder camperList(List<Camper> camperList) {
            this.camperList = camperList;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(id, name, description, engineCapacity, engineType, camperList);
        }
    }
}
