package crud.application.services.implementations;

import crud.application.entities.User;
import crud.application.resources.dtosV1.PaymentDtoV1;
import crud.application.services.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public List<PaymentDtoV1> findAll() {
        return null;
    }

    @Override
    public PaymentDtoV1 findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User insert(PaymentDtoV1 paymentDtoV1) {
        return null;
    }

    @Override
    public PaymentDtoV1 update(PaymentDtoV1 paymentDtoV1, Integer id) {
        return null;
    }
}
