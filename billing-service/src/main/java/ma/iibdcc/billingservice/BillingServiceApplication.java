package ma.iibdcc.billingservice;

import ma.iibdcc.billingservice.entities.Bill;
import ma.iibdcc.billingservice.entities.ProductItem;
import ma.iibdcc.billingservice.repositories.BillRepository;
import ma.iibdcc.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository) {
        return args -> {
            List<Long> customersIds = List.of(1L,2L,3L);
            List<Long> productIds = List.of(1L,2L,3L);
            customersIds.forEach(customrId->{
                Bill bill = new Bill();
                bill.setBillingDate(new Date());
                bill.setCustomerId(customrId);
                billRepository.save(bill);
                productIds.forEach(productId->{
                    ProductItem productItem = new ProductItem();
                    productItem.setProductId(productId);
                    productItem.setPrice(1000*Math.random()*250);
                    productItem.setQuantity(1+new Random().nextInt(20));
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);
                });
            });
        };
    }

}
