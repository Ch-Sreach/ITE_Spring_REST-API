package co.istad.productapisimpledemo.service;


import co.istad.productapisimpledemo.dto.CategoryRequest;
import co.istad.productapisimpledemo.dto.CategoryResponse;
import co.istad.productapisimpledemo.dto.UpdateCategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    List<CategoryResponse> findAllCategory();
    CategoryResponse updateCategory(Integer id, UpdateCategoryRequest categoryRequest);
    CategoryResponse findCategoryById(Integer id);
    Boolean deleteCategory(Integer id);
}
