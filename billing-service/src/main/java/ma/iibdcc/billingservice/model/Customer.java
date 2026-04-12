package ma.iibdcc.billingservice.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private  Long id;
    private  String name;
    private  String email;
}
