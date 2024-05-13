package pl.Lukaszmaguda.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    SalesFacade salesFacade;

    public SalesController(SalesFacade sales) {
        this.salesFacade = salesFacade;
    }
    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);
    }

    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable String productId){
        String customerId = getCurrentCustomerId();
        salesFacade.addToCart(customerId, productId);
    }
    @PostMapping
    ReservationDetail acceptOffer(AcceptOfferRequest acceptOfferRequest){
        String customerId=getCurrentCustomerId();
        ReservationDetail reservationDetail=
                salesFacade.acceptOffer(customerId, acceptOfferRequest);
                return reservationDetail;
    }

    private String getCurrentCustomerId(){

        return "Łukasz";
    }
}