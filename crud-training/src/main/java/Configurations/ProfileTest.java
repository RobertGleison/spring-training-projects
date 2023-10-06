package Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import product.Product;
import product.ProductRepository;
import product.ProductService;

import java.util.Arrays;

@Profile("Test")
@Configuration
public class ProfileTest implements CommandLineRunner {
    @Autowired
    private Product product;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 9000);
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 219000);
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 125000);
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 120000);
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 10099);

        repository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
