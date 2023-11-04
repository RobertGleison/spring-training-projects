package crud.application.services;

import crud.application.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
    Product insert(Product product);
    Product update(Integer id, Product product);

}
