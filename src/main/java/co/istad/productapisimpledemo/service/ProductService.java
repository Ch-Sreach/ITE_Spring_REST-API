package co.istad.productapisimpledemo.service;

import co.istad.productapisimpledemo.dto.ProductRequest;
import co.istad.productapisimpledemo.dto.ProductResponse;
import co.istad.productapisimpledemo.dto.UpdateProductRequest;
import co.istad.productapisimpledemo.entity.Product;

import java.util.List;

// for the loosely coupling design
//This interface will be implemented by other class
public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> findAllProducts();
    ProductResponse findProductById(Integer id);
    ProductResponse updateProduct(Integer id, UpdateProductRequest updateProductRequest);
    boolean deleteProduct(int id);
}
