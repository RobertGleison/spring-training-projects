package crud.application.resources.dtosV1;

import crud.application.entities.Order;
import java.time.Instant;

public record PaymentRequestDtoV1(Instant paymentMoment, Order order){
}
