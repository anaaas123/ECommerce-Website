package com.example.anakompjuteri.dto;

import com.example.anakompjuteri.model.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Category is required")
    private Category category;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Add availability")
    private boolean available;


}
