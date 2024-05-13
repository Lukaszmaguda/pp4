package pl.Lukaszmaguda.ecommerce.sales;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.FactoryBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class SalesHttpTest {
    @Autowired
    TestRestTemplate http;
    @LocalServerPort
    private int port;


    @Test
    void itAllowToAcceptOffer(){
        String productId=thereIsExampleProduct();

        String addProductURL=String.format(
                "http://localhost:%s/%s/%s",
                port,
                "api/add-to-cart/",
                productId);
        ResponseEntity<Object> addProductResponse = http.postForEntity(
                addProductURL, null, Object.class);

        String acceptOfferUrl = String.format(
                "http://localhost:%s/%s",
                port,
                "api/accept-offer"
        );
        AcceptOfferRequest acceptOfferRequest=new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("Łukasz")
                .setLastName("Maguda")
                .setEmail("lukasz.maguda11@onet.pl");

        ResponseEntity<ReservationDetail> reservationDetailResponseEntity=
                http.postForEntity(acceptOfferUrl,null,ReservationDetail.class);

        assertEquals(reservationDetailResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(reservationDetailResponseEntity.getBody().getPaymentUrl());

    }
    private String thereIsExampleProduct(){
        return "productX";
    }


}
