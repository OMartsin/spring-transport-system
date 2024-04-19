package com.example.transportsystem.controller;

import com.example.transportsystem.dto.finoperations.FinanceOperationRequest;
import com.example.transportsystem.dto.finoperations.FinanceOperationResponse;
import com.example.transportsystem.service.fin.FinanceOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/finance-operations")
public class FinanceOperationController {
    private final FinanceOperationService financeOperationService;

    @GetMapping
    public ResponseEntity<Page<FinanceOperationResponse>> findAll(@RequestParam(required = false, defaultValue = "0") int page,
                                                                  @RequestParam(required = false, defaultValue = "100") int size){
        return ResponseEntity.ok(financeOperationService.findAll(page, size));
    }


    @PostMapping
    public ResponseEntity<FinanceOperationResponse> save
            (@RequestBody FinanceOperationRequest financeOperationResponse){
        return ResponseEntity.ok(financeOperationService.save(financeOperationResponse));
    }

    @PutMapping
    public ResponseEntity<FinanceOperationResponse> update
            (@RequestBody FinanceOperationRequest financeOperationResponse){
        return ResponseEntity.ok(financeOperationService.update(financeOperationResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        financeOperationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
