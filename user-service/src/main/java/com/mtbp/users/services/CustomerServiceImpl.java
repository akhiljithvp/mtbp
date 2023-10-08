package com.mtbp.users.services;

import com.mtbp.commons.dto.users.AddCustomerRequest;
import com.mtbp.commons.dto.users.CustomerDto;
import com.mtbp.commons.dto.users.UpdateCustomerRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Customer;
import com.mtbp.db.users.services.CustomerDbService;
import com.mtbp.users.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerDbService customerDbService;

    @Override
    public CustomerDto addCustomer(AddCustomerRequest addCustomerRequest) {
        Customer customer = customerMapper.map(addCustomerRequest);
        return customerMapper.map(customerDbService.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest) {
        String customerId = DocKeyUtils.createCustomerDocKey(id);
        return customerDbService.findById(customerId).map(
            customer -> {
                customer = customerMapper.map(customer, updateCustomerRequest);
                return customerMapper.map(customerDbService.save(customer));
            }
        ).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", customerId))
        );
    }

    @Override
    public CustomerDto findCustomer(String id) {
        String customerId = DocKeyUtils.createCustomerDocKey(id);
        return customerDbService.findById(customerId).map(customerMapper::map).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", customerId))
        );
    }

    @Override
    public boolean deleteCustomer(String id) {
        try {
            customerDbService.deleteById(DocKeyUtils.createCustomerDocKey(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
