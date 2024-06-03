package pl.Lukaszmaguda.ecommerce.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import org.springframework.http.HttpHeaders;

public class PayU {
    RestTemplate http;

    public PayU(RestTemplate http) {
        this.http = http;
    }

    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content Type")
        http.postForEntity(
                "https://secure.snd.payu.com/api/v2_1/orders",
                orderCreateRequest,
                OrderCreateRequest.class
        );
        //Create order
        return orderCreateResponseRequest.getBody();

    }
    private String getToken(){
        String body = String.format("",
                "",
                ""
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity(String)
    }
}
