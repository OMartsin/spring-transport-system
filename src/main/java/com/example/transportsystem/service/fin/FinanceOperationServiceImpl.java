package com.example.transportsystem.service.fin;

import com.example.transportsystem.dto.finoperations.FinanceOperationRequest;
import com.example.transportsystem.dto.finoperations.FinanceOperationResponse;
import com.example.transportsystem.mapper.FinanceOperationsMapper;
import com.example.transportsystem.repository.FinanceOperationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceOperationServiceImpl implements FinanceOperationService{
    private final FinanceOperationsRepository financeOperationsRepository;
    private final FinanceOperationsMapper finMapper;

    public Page<FinanceOperationResponse> findAll(int page, int size){
        if(size == -1){
            return financeOperationsRepository.findAll(PageRequest.of(page, Integer.MAX_VALUE)).map(finMapper::toDto);
        }
        var pageRequest = PageRequest.of(page, size);
        return financeOperationsRepository.findAll(pageRequest).map(finMapper::toDto);
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
