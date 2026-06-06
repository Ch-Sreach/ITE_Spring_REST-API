package co.istad.productapisimpledemo.service;

import co.istad.productapisimpledemo.dto.CategoryRequest;
import co.istad.productapisimpledemo.dto.CategoryResponse;
import co.istad.productapisimpledemo.dto.UpdateCategoryRequest;
import co.istad.productapisimpledemo.entity.Category;
import co.istad.productapisimpledemo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private Integer nextId = 1007;

    private CategoryResponse mapToResponse(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getIsActive()
        );
    }

    private Category mapToEntity(CategoryRequest request){
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());
        category.setIsActive(request.isActive());
        return category;
    }


    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        var category = mapToEntity(request);
        category.setId(nextId++);
        return mapToResponse(categoryRepository.createCategory(category));
    }

    @Override
    public List<CategoryResponse> findAllCategory() {
        return categoryRepository.getAllCategory().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CategoryResponse updateCategory(Integer id, UpdateCategoryRequest request) {
        var existingCategory = categoryRepository.findCategoryById(id);
        if (request.name() != null)
            existingCategory.setName(request.name());
        if (request.description() != null)
            existingCategory.setDescription(request.description());
        if (request.isActive() != null)
            existingCategory.setIsActive(request.isActive());
        categoryRepository.updateCategoryById(existingCategory);

        return mapToResponse(existingCategory);
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        return mapToResponse(
                categoryRepository.findCategoryById(id)
        );
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        categoryRepository.findCategoryById(id);
        return categoryRepository.deleteCategoryById(id);
    }
}
