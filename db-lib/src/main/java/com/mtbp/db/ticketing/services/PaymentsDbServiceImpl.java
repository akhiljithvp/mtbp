package com.mtbp.db.ticketing.services;

import com.mtbp.db.LogMessages;
import com.mtbp.db.repositories.PaymentsRepository;
import com.mtbp.db.ticketing.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentsDbServiceImpl implements PaymentsDbService {

    private final PaymentsRepository paymentsRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentsRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(String id) {
        return paymentsRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            paymentsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(LogMessages.DOC_DELETION_EXCEPTION, id, e);
            return false;
        }
    }
}
