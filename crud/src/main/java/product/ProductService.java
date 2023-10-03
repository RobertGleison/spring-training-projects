package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService{
    @Autowired
    ProductRepository repository;

    public Product findProductById(Long id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

    public List<Product> findAllProducts(){
        List<Product> products = repository.findAll();
        return products;
    }

    public void createProduct(@RequestBody Product product){
        repository.save(product);

    }
//
//    public void deleteProductById(Long id){
//        if()
//    }

}
