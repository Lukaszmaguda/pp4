package pl.Lukaszmaguda.ecommerce.catalog;

import java.util.List;
import java.util.UUID;

public interface ProductStorage {
    List<Product> allProducts();

    void add(Product newProduct);

    Product getProductBy(String id);

    class ProductCatalog {
        ArrayListProductStorage productStorage;

        public ProductCatalog(){
            this.productStorage=new ArrayListProductStorage();
        }

        public List<Product> allProducts()
        {
            return productStorage.allProducts();
        }

        public String addProduct(String name, String description) {
            UUID id = UUID.randomUUID();
            Product newProduct = new Product(id, name, description);

            productStorage.add(newProduct);

            return id.toString();
        }

        public Product getProductBy(String id) {
            return arrayListProductStorage.getProductBy(id);

        public void changePrice(String id, BigDecimal price) {
            Product loaded = this.getProductBy(id);
            loaded.changePrice(price);
        }
    }
}
