package com.example.FinanceTracker;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String transactionName;
    private double transactionAmount;
    private String transactionCategory;
    private LocalDate transactionDate;

    public Finance(){

    }
    public Finance(Long id, String transactionName, double transactionAmount, String transactionCategory, LocalDate transactionDate){
        this.id = id;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.transactionCategory = transactionCategory;
        this.transactionDate = transactionDate;
    }

    public Long getId(){
        return id;
    }
    public String getTransactionName(){
        return transactionName;
    }
    public double getTransactionAmount(){
        return transactionAmount;
    }
    public String getTransactionCategory(){
        return transactionCategory;
    }
    public LocalDate getTransactionDate(){
        return transactionDate;
    }

    /*public String getAllData(){

        return id + " " + transactionName + " $" + transactionAmount + " " + transactionCategory + " " + transactionDate;
    }*/
    
    public void setTransactionName(String transactionName){
        this.transactionName = transactionName;
    }
    public void setTransactionAmount(double transactionAmount){
        this.transactionAmount = transactionAmount;
    }
    public void setTransactionCategory(String transactionCategory){
        this.transactionCategory = transactionCategory;
    }
    public void setTransactionDate(LocalDate transactionDate){
        this.transactionDate = transactionDate;
    }
    public void setId(Long id){
        this.id = id;
    }


}
