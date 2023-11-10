package crud.application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import crud.application.resources.dtosV1.UserRequestDtoV1;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(UserRequestDtoV1 userDto) {
        this.id = userDto.id();
        this.name = userDto.name();
        this.email = userDto.email();
        this.phone = userDto.phone();
        this.password = userDto.password();
    }

    public User(Integer id, String name, String email, String phone, String password) { //UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        //this.role = role;
    }

    public User(String name, String email, String password) { //UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        //this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
