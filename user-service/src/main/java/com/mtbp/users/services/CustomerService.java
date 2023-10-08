package com.mtbp.users.services;

import com.mtbp.commons.dto.users.AddCustomerRequest;
import com.mtbp.commons.dto.users.CustomerDto;
import com.mtbp.commons.dto.users.UpdateCustomerRequest;

public interface CustomerService {
    CustomerDto addCustomer(AddCustomerRequest addCustomerRequest);

    CustomerDto updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest);

    boolean deleteCustomer(String id);

    CustomerDto findCustomer(String id);
}
