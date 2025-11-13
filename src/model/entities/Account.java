package model.entities;

import model.exceptions.BusinessException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawalLimit;

    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withdrawalLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawalLimit = withdrawalLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(Double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
        System.out.printf("New balance: %.2f%n", this.balance);
    }

    public void withdraw(Double amount){
       validateWithdraw(amount);

        this.balance -= amount;
        System.out.printf("New balance: %.2f%n", this.balance);
    }

    private void validateWithdraw(double amount){
        if (amount > withdrawalLimit)
            throw new BusinessException("Withdraw error: the amount exceeds withdraw limit");
        else if (amount > this.balance)
            throw new BusinessException("Withdraw error: Not enough balance");
    }
}
