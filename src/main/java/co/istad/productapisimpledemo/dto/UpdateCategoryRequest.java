package co.istad.productapisimpledemo.dto;

public record UpdateCategoryRequest(
        String name,
        String description,
        Boolean isActive
) {
}
