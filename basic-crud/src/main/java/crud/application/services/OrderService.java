package crud.application.services;

import crud.application.entities.Order;
import crud.application.resources.dtosV1.OrderDtoV1;


import java.util.List;

public interface OrderService {
    List<OrderDtoV1> findAll();
    OrderDtoV1 findById(Integer id);
    void deleteById(Integer id);
    Order insert(OrderDtoV1 orderDtoV1);
    OrderDtoV1 update(OrderDtoV1 orderDtoV1, Integer id);
}
