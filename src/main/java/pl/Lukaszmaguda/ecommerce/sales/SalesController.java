package pl.Lukaszmaguda.ecommerce.sales;

public class SalesController {
    salesFacade salesFacade;


    public salesController(SalesFacade salesFacade){
        this.salesFacade=salesFacade;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId= getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);

    }

    private String getCurrentCustomerId() {
        return "Łukasz";
    }
}
