package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }


    @Override
    public int withdraw(int amountOfWithdraw) {
        int amountOfMoneyAfterWithdraw = getBalance() - amountOfWithdraw;
        int serviceCharge = 2;
        int moneyAfterServiceCharge = amountOfMoneyAfterWithdraw - serviceCharge;

        if ( amountOfMoneyAfterWithdraw < 150 && moneyAfterServiceCharge>=0) {
            return super.withdraw(amountOfWithdraw + 2);


        } else if (moneyAfterServiceCharge < 0 ) {
            return getBalance();

        } else if ( moneyAfterServiceCharge > 0 && amountOfMoneyAfterWithdraw < 150) {
            return moneyAfterServiceCharge;
        } else {

        }
        return super.withdraw(amountOfWithdraw);
    }
}








