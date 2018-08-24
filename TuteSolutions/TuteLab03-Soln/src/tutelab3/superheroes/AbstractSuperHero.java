package tutelab3.superheroes;

import tutelab3.interfaces.SuperHero;

// minimise code duplication by placing common functionality here
public abstract class AbstractSuperHero implements SuperHero
{
	private String name;
	private String location;

	protected AbstractSuperHero(String name, String location)
	{
		this.name = name;
		this.location = location;
	}

	@Override
	public void saveTheWorld()
	{
		System.out.println(String.format("%s saves %s again!", name, location));
	}
}
