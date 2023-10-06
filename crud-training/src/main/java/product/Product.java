package product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    private String name;
    private String description;
    private int priceinCents;

    public Product() {
    }

    public Product(Integer id, String name, String description, int priceinCents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceinCents = priceinCents;
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
        return priceinCents;
    }

    public void setPriceinCents(int priceinCents) {
        this.priceinCents = priceinCents;
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
                ", priceinCents=" + priceinCents +
                '}';
    }
}

