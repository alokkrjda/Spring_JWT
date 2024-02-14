package org.example.Controller;

import org.example.Model.Product;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        System.out.println("End point add product is hit");
        return productService.addProduct(product);
    }

    @PostMapping("/{productid}/{categoryid}")
    public void linkProductWithCategoryId(@PathVariable int productid, @PathVariable int categoryid) {
        productService.linkProductWithCategory(productid,categoryid);
    }

    @PostMapping("/{productid}")
    public Product findProduct(@PathVariable int productid) {
        return productService.findProductById(productid);
    }

    @PostMapping("/update/{id}")
    public Product updateProductById(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProductById(id,product);
    }
    @GetMapping("/products")
    public java.util.List<Product> findAll() {
        return  productService.getAlProducts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @PostMapping("/getProductByAnyField")
    public List<Product> getProductByAnyField(@RequestBody Product product) {
        return productService.getProductByAnyField(product);
    }
}
