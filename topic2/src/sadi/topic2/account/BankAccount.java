package sadi.topic2.account;

public class BankAccount
{
	protected String id;
	protected double balance;

	public BankAccount(String id, double balance)
	{
		this.id = id;
		this.balance = balance;
	}

	public boolean withdraw(double amount)
	{
		return false;
	}

	public void deposit(double amount)
	{
	}

	public boolean transfer(BankAccount dest, double amount)
	{
		if (withdraw(amount))
		{
			dest.deposit(amount);
			return true;
		}

		return false;
	}

	public String getId()
	{
		return id;
	}

	public double getBalance()
	{
		return balance;
	}

	//	@Override
	public String toString()
	{
		return String.format("id=%s, balance=%s", id, balance);
	}
}
