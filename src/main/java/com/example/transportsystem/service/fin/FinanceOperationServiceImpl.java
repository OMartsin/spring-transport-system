package com.example.transportsystem.service.fin;

import com.example.transportsystem.dto.finoperations.FinanceOperationRequest;
import com.example.transportsystem.dto.finoperations.FinanceOperationResponse;
import com.example.transportsystem.mapper.FinanceOperationsMapper;
import com.example.transportsystem.repository.FinanceOperationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceOperationServiceImpl implements FinanceOperationService{
    private final FinanceOperationsRepository financeOperationsRepository;
    private final FinanceOperationsMapper finMapper;

    public Page<FinanceOperationResponse> findAll(int page, int size){
        if(size < 0 || page < 0)
            return financeOperationsRepository.findAll(PageRequest.of(0,
                            Integer.MAX_VALUE, Sort.by("timestamp").descending()))
                    .map(finMapper::toDto);
        return financeOperationsRepository.findAll(PageRequest.of(page, size, Sort.by("timestamp").descending()))
                .map(finMapper::toDto);
    }

    public FinanceOperationResponse save(FinanceOperationRequest financeOperationRequest){
        var financeOperation = finMapper.toEntity(financeOperationRequest);
        financeOperation.setOrder(null);
        return finMapper.toDto(financeOperationsRepository.save(financeOperation));
    }

    public FinanceOperationResponse update(FinanceOperationRequest financeOperationRequest){
        var financeOperation = finMapper.toEntity(financeOperationRequest);
        financeOperation.setOrder(null);
        return finMapper.toDto(financeOperationsRepository.save(financeOperation));
    }

    public void deleteById(Long id){
        financeOperationsRepository.deleteById(id);
    }

}
