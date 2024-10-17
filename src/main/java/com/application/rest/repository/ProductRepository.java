package com.application.rest.repository;
import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{
    //Opción 1
    //@Query (notación query ó @Query,  usa el lenguaje jpql)
    //@Query ("SELECT p FROM Product p WHERE p.price >= ?1 AND p.price <= ?2")
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    //opcion dos Query methods (usando el nombre del Método) Between si existen en JPA
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}