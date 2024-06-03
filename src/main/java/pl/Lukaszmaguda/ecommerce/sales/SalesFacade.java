package pl.Lukaszmaguda.ecommerce.sales;

import pl.Lukaszmaguda.ecommerce.sales.cart.Cart;
import pl.Lukaszmaguda.ecommerce.sales.offering.AcceptOfferRequest;
import pl.Lukaszmaguda.ecommerce.sales.offering.Offer;
import pl.Lukaszmaguda.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {
    private InMemoryCartStorage cartStorage;

    public Offer getCurrentOffer(String customerId) {

        Cart cart = loadCartForCustomer(customerId);

        Offer currentOffer = offerCalculator.calculate(cart.getLines());

        return currentOffer;
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest){
        return new ReservationDetail();
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());

    }
}