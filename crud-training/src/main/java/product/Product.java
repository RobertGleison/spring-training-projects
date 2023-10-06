package product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of="id")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    private String name;
    private String description;
    private int priceinCents;
}
