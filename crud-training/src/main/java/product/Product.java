package product;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="products")
public class Product implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="Name")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name="PriceInCents")
    private int priceInCents;

    public Product() {
    }

    public Product(Integer id, String name, String description, int priceInCents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceInCents = priceInCents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriceinCents() {
        return priceInCents;
    }

    public void setPriceinCents(int priceinCents) {
        this.priceInCents = priceinCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceinCents=" + priceInCents +
                '}';
    }
}

