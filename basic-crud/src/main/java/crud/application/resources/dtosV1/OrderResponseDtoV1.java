package crud.application.resources.dtosV1;

import crud.application.entities.User;
import crud.application.enums.OrderStatus;

import java.time.Instant;

public record OrderResponseDtoV1 (Instant orderMoment, OrderStatus status, User user){
}
