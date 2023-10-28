package com.example.crude2.repository;

import com.example.crude2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/* JpaRepository <model name, data type of our primary key>*/
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
        /*we need write some logic here to connect to our database.
         But if you're using Spring Boot you don't need to write additional logics for database connection.
         All the database related properties you can add in Application.properties file. All the hibernate related
         properties and datasource related properties we'll add there.
         */

}

