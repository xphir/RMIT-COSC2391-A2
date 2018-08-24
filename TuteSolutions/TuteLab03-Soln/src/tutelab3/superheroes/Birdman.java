package tutelab3.superheroes;

import tutelab3.interfaces.FlyingHero;

public class Birdman extends AbstractSuperHero implements FlyingHero
{
	public Birdman()
	{
		super("Birdman", "The World");
	}

	// inherits saveTheWorld from AbstractSuperhero

	@Override
	public void fly()
	{
		System.out.println("Birdman is flying close to the sun");
	}
}
