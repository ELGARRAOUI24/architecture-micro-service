package ma.iibdcc.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", p -> p.path("/customers/**")
                        .uri("lb://CUSTOMER-SERVICE"))
                .route("r2", p -> p.path("/customers/**")
                        .uri("lb://INVENTORY-SERVICE"))
                .build();
    }
}
