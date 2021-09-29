package com.techelevator;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable{

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //public List<Accountable> getAccounts() {
        //return accounts;
   // }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount) ;

    }

    public boolean isVip() {
        //List<Accountable> accounts = new ArrayList<Accountable>();
        int balance=0;

        for (int i=0; i<this.accounts.size(); i++) {
            Accountable account = this.accounts.get(i);
            balance = balance + account.getBalance();
        }
           if (balance >= 25000) {
                return true;
            } else {
        }
        return false;
    }

    @Override
    public int getBalance() {
        return 0;
    }


}
