package crud.application.services;

import crud.application.entities.Product;
import crud.application.entities.User;
import crud.application.resources.dtosV1.ProductDtoV1;

import crud.application.resources.dtosV1.UserResponseDtoV1;

import java.util.List;

public interface ProductService {
    List<ProductDtoV1> findAll();
    ProductDtoV1 findById(Integer id);
    void deleteById(Integer id);
    ProductDtoV1 insert(ProductDtoV1 productDtoV1);
    ProductDtoV1 update(ProductDtoV1 productDtoV1, Integer id);

}
