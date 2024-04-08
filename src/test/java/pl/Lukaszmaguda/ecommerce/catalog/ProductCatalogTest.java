package pl.Lukaszmaguda.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itListAvailableProducts() {
        ProductStorage.ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }



    @Test
    void itAllowsToAddProduct() {
        ProductStorage.ProductCatalog catalog = thereIsProductCatalog();

        catalog.addProduct("Lego set 8083", "Nice one");
        List<Product> products = catalog.allProducts();

        assertThat(products)
                .hasSize(1);
    }

    @Test
    void itLoadsSingleProductById() {
        ProductStorage.ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");

        Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());
    }

    @Test
    void itAllowsChangePrice() {
        ProductStorage.ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductBy(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }

    private static ProductStorage.ProductCatalog thereIsProductCatalog() {
        return new ProductStorage.ProductCatalog();
    }
}
