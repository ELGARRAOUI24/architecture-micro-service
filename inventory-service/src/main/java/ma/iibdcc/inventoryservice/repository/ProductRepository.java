package ma.iibdcc.inventoryservice.repository;

import ma.iibdcc.inventoryservice.entities.Product;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface ProductRepository extends JpaRepository<Product, Long> {

}
