package ma.iibdcc.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.iibdcc.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name="inventory-service", fallbackMethod = "getDefaultProduct")
    Product findProductById(@PathVariable("id") Long id);

    default Product getDefaultProduct(Long id, Exception ex) {
        return Product.builder().id(id).build();
    }
}
