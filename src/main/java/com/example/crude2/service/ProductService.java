package com.example.crude2.service;

import com.example.crude2.entity.Product;
import com.example.crude2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    /*now we'll write post method through which we'll save  the product to our database */
    public Product saveProduct(Product product){
           return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    /*Let's write get method to fetch/retrieve product object from database*/
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return repository.findByName(name);
    }
    /*Now we're going to write delete method*/
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !!" + id;
    }
    /*update product*/
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

}
