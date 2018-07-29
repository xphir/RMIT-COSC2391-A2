package sadi.topic2.bank;

import sadi.topic2.account.BankAccount;
import sadi.topic2.account.CreditAccount;
import sadi.topic2.account.SavingsAccount;

public class Bank
{
	public static void main(String[] args)
	{
		BankAccount accounts[] = new BankAccount[]
		{ new SavingsAccount("1", 1000.0), new SavingsAccount("2", 1000.0), new CreditAccount("3", 1000.0),
				new CreditAccount("4", 1000.0) };

		accounts[0].transfer(accounts[3], 100.0);
		accounts[2].transfer(accounts[1], 100.0);
		accounts[0].transfer(accounts[2], 100.0);

		for (BankAccount account : accounts)
			System.out.println(account.toString());
	}
}
