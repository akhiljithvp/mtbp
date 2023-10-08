package com.mtbp.db.users.services;

import com.mtbp.db.LogMessages;
import com.mtbp.db.repositories.CustomerRepository;
import com.mtbp.db.users.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerDbServiceImpl implements CustomerDbService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(LogMessages.DOC_DELETION_EXCEPTION, id, e);
            return false;
        }
    }
}
