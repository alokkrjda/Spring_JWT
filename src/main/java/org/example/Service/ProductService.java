package org.example.Service;

import org.example.Model.Category;
import org.example.Model.Product;
import org.example.Repository.CategoryRepository;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepo = productRepository;
        this.categoryRepo = categoryRepository;
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public void linkProductWithCategory(int productId, int categoryId) {
        Product product = productRepo.findById(productId).get();
        Category category = categoryRepo.findById(categoryId).get();

        product.setCategory(category);
        productRepo.save(product);
    }

    public Product findProductById(int productId) {
        return productRepo.findById(productId).get();
    }

    public Product updateProductById(int id, Product product) {
        Product findProduct = productRepo.findById(id).get();
        if(product.getProductname()!=null) {
            findProduct.setProductname(product.getProductname());
        }
        if(product.getProductdes()!=null) {
            findProduct.setProductdes(product.getProductdes());
        }
        if(product.getProductprice()!=0) {
            findProduct.setProductprice(product.getProductprice());
        }
        if(product.getCategory()!=null) {
            findProduct.setCategory(product.getCategory());
        }
        productRepo.save(findProduct);
        return findProduct;
    }

    public List<Product> getAlProducts() {
        return productRepo.findAll();
    }

    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> getProductByAnyField(Product product) {
        if(product.getProductname().equals(null)) {
            product.setProductname("%");
        }
        if(product.getProductdes().equals(null)) {
            product.setProductdes("%");
        }
        if(product.getProductprice().equals(null)) {
            return productRepo.getProductByAnyField(product.getProductname(),product.getProductdes());
        }
        return productRepo.getProductByAnyField(product.getProductname(),product.getProductprice(),product.getProductdes());
    }
}
