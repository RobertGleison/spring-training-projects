package crud.application.repositories;

import crud.application.entities.OrderItem;
import crud.application.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
