package co.istad.productapisimpledemo.service;

import co.istad.productapisimpledemo.dto.ProductRequest;
import co.istad.productapisimpledemo.dto.ProductResponse;
import co.istad.productapisimpledemo.dto.UpdateProductRequest;

import java.util.List;

public interface CategoryService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> findAllProducts();
    ProductResponse findProductById(Integer id);
    ProductResponse updateProduct(Integer id, UpdateProductRequest updateProductRequest);
    boolean deleteProduct(int id);
}
