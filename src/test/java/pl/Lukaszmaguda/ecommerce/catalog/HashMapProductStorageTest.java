package pl.Lukaszmaguda.ecommerce.catalog;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.*;
public class HashMapProductStorageTest {
    @Test
    void itAllowsToStoreProduct(){
        Product product= thereIsExampleProduct();
        ProductStorage hashmapStorage = thereIsHashMapStorage();
        hashmapStorage.add(product);

        List<Product> products = hashmapStorage.allProducts();
        asserThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains("test-it");
    }

    private Product thereIsExampleProduct() {
        return new Product();
    }

    @Test
    void itAllowsToLoadAllProducts(){

    }
    @Test
    void itALlowsToLoadProductById(){

    }
}

