package crud.application.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import crud.application.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant orderMoment;
    @NotBlank
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "users_id")
    @NotNull
    @NotBlank
    private User user;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> products = new HashSet<>();
    //Do not need to add to constructor, because the value can be null
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Integer id, Instant orderMoment, Integer status, User user) {
        this.id = id;
        this.orderMoment = orderMoment;
        this.status = status;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getOrderMoment() {
        return orderMoment;
    }

    public void setOrderMoment(Instant orderMoment) {
        this.orderMoment = orderMoment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(Set<OrderItem> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItem item: products) {
            sum += item.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderMoment=" + orderMoment +
                ", status=" + status +
                '}';
    }
}
