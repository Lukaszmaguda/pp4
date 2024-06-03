package pl.Lukaszmaguda.ecommerce.infrastructure;

import pl.Lukaszmaguda.ecommerce.sales.payment.PaymentDetails;
import pl.Lukaszmaguda.ecommerce.sales.payment.PaymentGateway;
import pl.Lukaszmaguda.ecommerce.sales.payment.RegisterPaymentRequest;
public class PayUPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
