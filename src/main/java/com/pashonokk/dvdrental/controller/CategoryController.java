package com.pashonokk.dvdrental.controller;

import com.pashonokk.dvdrental.dto.CategoryDto;
import com.pashonokk.dvdrental.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public static final String REDIRECT_TO_ALL = "categories";

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new RedirectView(REDIRECT_TO_ALL);
    }

    @PostMapping
    public RedirectView addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        return new RedirectView(REDIRECT_TO_ALL);
    }

    @PutMapping("/{id}")
    public RedirectView updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryService.addCategory(categoryDto);
        return new RedirectView(REDIRECT_TO_ALL);
    }

}
