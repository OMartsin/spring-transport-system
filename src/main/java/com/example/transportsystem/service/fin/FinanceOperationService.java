package com.example.transportsystem.service.fin;

import com.example.transportsystem.dto.finoperations.FinanceOperationRequest;
import com.example.transportsystem.dto.finoperations.FinanceOperationResponse;
import org.springframework.data.domain.Page;

public interface FinanceOperationService {
    Page<FinanceOperationResponse> findAll(int page, int size);
    FinanceOperationResponse save(FinanceOperationRequest financeOperationRequest);
    FinanceOperationResponse update(FinanceOperationRequest financeOperationRequest);
    void deleteById(Long id);
}
