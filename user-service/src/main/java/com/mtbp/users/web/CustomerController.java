package com.mtbp.users.web;

import com.mtbp.commons.dto.users.AddCustomerRequest;
import com.mtbp.commons.dto.users.CustomerDto;
import com.mtbp.commons.dto.users.UpdateCustomerRequest;
import com.mtbp.users.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        CustomerDto customer = customerService.addCustomer(addCustomerRequest);
        URI location = UriHelperUtils.createUriFrom(CustomerController.class, "customers", customer.getId());
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable String id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        CustomerDto customer = customerService.updateCustomer(id, updateCustomerRequest);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomer(@PathVariable String id) {
        CustomerDto customer = customerService.findCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}