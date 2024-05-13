package pl.Lukaszmaguda.ecommerce.sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;



@Test
void itAllowsToAddMultipleProductsToCart(){
    var  sales = thereIsSalesFacade();
    var customerId = thereIsCustomer("Łukasz");

    Offer offer = sales.getCurrentOffer(customerId);

    assertEquals(0,offer.getItemsCount());
    assertEquals(BigDecimal.ZERO, offer.getTotal());
}

public class SalesTest {
    @Test
    void itAddProductToCart(){
        SalesFacade sales = thereIsSalesFacade();
        var productId = thereIsProduct("product a", BigDecimal.valueOf(10));
        SalesFacade sales= thereIsSalesFacade();

        sales.addToCart(customerId,productId);

        Offer currentOffer=sales.getCurrentOffer(customerId);
        assertEquals(BigDecimal.valueOf(10), currentOffer.getTotal());
        assertEquals(1,currentOffer.getItemsCount());

    }

    private String thereIsProduct(String name, BigDecimal price) {
        return name;
    }

    @Test
    void itShowsCurrentOffer(){
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsCustomer("Łukasz");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0,offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private String thereIsCustomer(String id) {
        return id;
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }
    @Test
    void itRemoveProductFromCart(){

    }
    @Test
    void itAllowToAcceptOffer(){

    }
    @Test
    void itAllowToPayForReservation(){

    }
}
