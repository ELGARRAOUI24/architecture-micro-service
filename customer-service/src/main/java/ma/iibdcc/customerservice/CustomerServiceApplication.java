package ma.iibdcc.customerservice;

import ma.iibdcc.customerservice.entities.Customer;
import ma.iibdcc.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
					.name("Imane").email("imane@gmail.com").build());
			customerRepository.save(Customer.builder()
					.name("Hassan").email("hassan@gmail.com").build());
			customerRepository.save(Customer.builder()
					.name("Amine").email("amine@gmail.com").build());
		};
	}

}
