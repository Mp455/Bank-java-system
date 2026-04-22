package co.marcos.bank.service;

import co.marcos.bank.model.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private final List<Account> accounts;
    private int lastAccount = 1;


    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    };

    public Account createAccount(String name) {
        Account account = new Account(ag, String.valueOf(lastAccount++), name);
        accounts.add(account);
        return account;
    }

    public List<Account> getAccounts(){
        return new ArrayList<>(accounts);
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }
}

