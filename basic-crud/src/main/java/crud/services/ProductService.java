package crud.services;

import crud.entities.Product;
import crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        products = repository.findAll();
        return products;
    }

}
