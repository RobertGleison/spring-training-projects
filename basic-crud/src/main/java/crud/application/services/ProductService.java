package crud.application.services;

import crud.application.entities.Product;
import crud.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> product = repository.findById(id);
        return product.get();
        }

}
