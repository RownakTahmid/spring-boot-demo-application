package com.example.crude2.controller;

import com.example.crude2.entity.Product;
import com.example.crude2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
/*This annotation indicates that this is a controller class and all the method in this marked class
 will return a json response*/

@RestController
public class ProductController {
    /*this will talk to the service class, so now we need to inject service here */
    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(List<Product> products){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")/*we need to pass id as part of request url. we will use @Pathvariable or @Request*/
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/products/{name}")/*the reason not using @Requestparam is,it might show 404 error */
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }



}
