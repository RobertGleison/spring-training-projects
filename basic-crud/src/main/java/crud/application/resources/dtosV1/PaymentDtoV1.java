package crud.application.resources.dtosV1;

import crud.application.entities.Order;
import java.time.Instant;

public record PaymentDtoV1(Integer Id, Instant paymentMoment, Order order){
}
