package sadi.topic1.bank.account;

import sadi.topic1.bank.exception.BankingException;

public interface Account
{
   public abstract void withdraw(Double amount) throws BankingException;
   public abstract void deposit(Double amount);
   public abstract String getId();
   public abstract void applyFees();
   public abstract void applyInterest();
}
