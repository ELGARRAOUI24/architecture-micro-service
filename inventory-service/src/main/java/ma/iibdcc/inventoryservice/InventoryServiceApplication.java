package ma.iibdcc.inventoryservice;

import ma.iibdcc.inventoryservice.entities.Product;
import ma.iibdcc.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(20)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(2300)
                    .quantity(27)
                    .build());
            productRepository.save(Product.builder()
                    .name("Ordinateur")
                    .price(4000)
                    .quantity(43)
                    .build());
        };
    }

}
