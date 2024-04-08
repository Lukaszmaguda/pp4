package pl.Lukaszmaguda.ecommerce.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCatalogController {

    ProductStorage.ProductCatalog catalog;

    public ProductCatalogController(ProductStorage.ProductCatalog catalog) {
        this.catalog = catalog;
    }

    @GetMapping("/api/products")
    List<Product> allProducts(){
        return catalog.allProducts();
    }
}
