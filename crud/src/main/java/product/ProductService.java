package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ProductService{
    @Autowired
    ProductRepository repository;


    public Product findProductById(Long id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

}
