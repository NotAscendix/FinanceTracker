package com.example.FinanceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FinanceTracker.Finance;
public interface FinanceRepository extends JpaRepository<Finance, Long> {

}
