package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }


@Override
    public int withdraw(int amountOfWithdraw) {

        if(getBalance()<0 && (getBalance() - amountOfWithdraw) > -100) {
            return super.withdraw(amountOfWithdraw+ 10);
        } else if (getBalance() - amountOfWithdraw - 10 <= -100) {
            return getBalance();
        } else {

            return super.withdraw(amountOfWithdraw);
        }
    }
}
