package crud.application.services.implementations;

import crud.application.entities.Payment;
import crud.application.entities.User;
import crud.application.exceptions.ResourceNotFoundException;
import crud.application.repositories.PaymentRepository;
import crud.application.resources.dtosV1.PaymentDtoV1;
import crud.application.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public List<PaymentDtoV1> findAll() {
        return repository.findAll().stream().map(this::convertPaymentToPaymentDtoV1).collect(Collectors.toList());
    }

    @Override
    public PaymentDtoV1 findById(Integer id) {
        Payment payment = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        return new PaymentDtoV1(payment);
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

    private PaymentDtoV1 convertPaymentToPaymentDtoV1(Payment payment) {
        return new PaymentDtoV1(
                payment.getId(),
                payment.getPaymentMoment(),
                payment.getOrder()
        );
    }
}
