package com.example.FinanceTracker.Controller;

import java.util.List;
import com.example.FinanceTracker.Finance;
import com.example.FinanceTracker.repository.FinanceRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/finance")
public class FinanceTrackerController {
    
    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping // dont need to put another /api/finance, putting none will just use request mapping's
    public List<Finance> getFinanceData() {
        return financeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Finance getFinanceDataById(@PathVariable Long id) {
        Finance exists = financeRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction id not found"));
        
        return exists;
    }  
    


    @PostMapping()
    public Finance createFinanceData(@RequestBody Finance finance){
        return financeRepository.save(finance);
    }


    @PutMapping("/{id}")
    
    public Finance updateFinanceData(@PathVariable Long id, @RequestBody Finance finance){
        Finance exists = financeRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction id not found"));
        //exists is just to check if the id to update actually exists, otherwise throw an exception error
        exists.setTransactionName(finance.getTransactionName());
        exists.setTransactionAmount(finance.getTransactionAmount());
        exists.setTransactionCategory(finance.getTransactionCategory());
        exists.setTransactionDate(finance.getTransactionDate());

        return financeRepository.save(exists);
        
        
    }
    @DeleteMapping("/{id}")

    public void deleteFinanceData(@PathVariable Long id){
        Finance exists = financeRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction id not found"));
        financeRepository.deleteById(id);
    }



}
