package pl.Lukaszmaguda.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.Lukaszmaguda.ecommerce.catalog.ProductStorage;

@SpringBootApplication
public class App {
    public static void main(String [] args){
        System.out.println("Here we go");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductStorage.ProductCatalog createMyProductCatalog(){
        ProductStorage.ProductCatalog productCatalog = new ProductStorage.ProductCatalog();
        productCatalog.addProduct("Lego set1", "Nice one");
        productCatalog.addProduct("Lego set2 ", "Nice one");
        return productCatalog;
    }
}
