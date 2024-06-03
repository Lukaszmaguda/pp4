package pl.Lukaszmaguda.ecommerce.payu;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class PayuTest {
    @Test
    void creatingNewPayment(){
        PayU payu = thereIsPayU();
        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }

    private OrderCreateRequest createExampleOrderCreateRequest() {
        var createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my/example.shop.Lmaguda.pl/api/order")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("My ebook")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setExtOrderId("1234567890")
                .setBuyer((new Buyer())
                        .setEmail("john.doe@example.com")
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setLanguage("pl")

                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Product X")
                                .setQuantity(1)
                                .setUnitPrice(21000)
                ));




        return createRequest;
    }

    private PayU thereIsPayU() {
        return new PayU(new RestTemplate());
    }
}
