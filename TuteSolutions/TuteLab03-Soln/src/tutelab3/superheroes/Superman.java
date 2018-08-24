package tutelab3.superheroes;

import tutelab3.interfaces.FlyingHero;

public class Superman extends AbstractSuperHero implements FlyingHero
{
	public Superman()
	{
		super("Superman", "The World");
	}

	// inherits saveTheWorld from AbstractSuperhero

	@Override
	public void fly()
	{
		System.out.println("Superman is flying to the fortress of solitude");
	}
}
