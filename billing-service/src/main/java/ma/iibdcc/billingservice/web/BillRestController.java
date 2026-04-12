package ma.iibdcc.billingservice.web;

import ma.iibdcc.billingservice.entities.Bill;
import ma.iibdcc.billingservice.feign.CustomerServiceRestClient;
import ma.iibdcc.billingservice.feign.InventoryServiceRestClient;
import ma.iibdcc.billingservice.model.Customer;
import ma.iibdcc.billingservice.repositories.BillRepository;
import ma.iibdcc.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;
    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(inventoryServiceRestClient.findProductById(pi.getProductId()));
        });
        return bill;
    }
}
