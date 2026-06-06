package co.istad.productapisimpledemo.restcontroller;


import co.istad.productapisimpledemo.dto.CategoryRequest;
import co.istad.productapisimpledemo.dto.CategoryResponse;
import co.istad.productapisimpledemo.dto.UpdateCategoryRequest;
import co.istad.productapisimpledemo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponse> getCategory(){
        return categoryService.findAllCategory();
    }

    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryRequest request){
        return categoryService.createCategory(request);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Integer id){
        return categoryService.findCategoryById(id);
    }

    @PatchMapping
    public CategoryResponse updateCategory(@PathVariable Integer id, @RequestBody UpdateCategoryRequest categoryRequest){
        return categoryService.updateCategory(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategoryById(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }
}
