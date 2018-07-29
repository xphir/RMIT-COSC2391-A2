package sadi.topic1.bank.account;

public abstract class AbstractAccount implements Account
{
	private String id;
	private Double balance;

	protected void setBalance(Double balance)
	{
		this.balance = balance;
	}

	public AbstractAccount(String id, Double balance)
	{
		super();
		this.id = id;
		this.balance = balance;
	}

	public String getId()
	{
		return id;
	}

	public Double getBalance()
	{
		return balance;
	}

	@Override
	public String toString()
	{
		return String.format("Account id: %s, balance=%.2f", getId(), getBalance());
	}
}
