package tutelab3.test;

import tutelab3.birds.Eagle;
import tutelab3.birds.Parrot;
import tutelab3.interfaces.Flyer;
import tutelab3.interfaces.FlyingHero;
import tutelab3.interfaces.SuperHero;
import tutelab3.superheroes.Aquaman;
import tutelab3.superheroes.Batman;
import tutelab3.superheroes.Birdman;
import tutelab3.superheroes.Superman;
import tutelab3.superheroes.WonderWoman;

// sample solution to TuteLab03 superhero problem by Caspar
public class TestHeirarchies
{
	// used by both methods
	private FlyingHero superman = new Superman();
	private FlyingHero birdman = new Birdman();

	public static void main(String[] args)
	{
		TestHeirarchies test = new TestHeirarchies();
		test.superHeroes();
		test.combinedFly();
	}

	// just the superheros
	public void superHeroes()
	{
		// only used locally
		SuperHero aquaman = new Aquaman();
		SuperHero batman = new Batman();
		SuperHero wonderwoman = new WonderWoman();

		// populate the arrays so we can loop them (no casting/type conversion required!)
		SuperHero[] superHeroes = new SuperHero[]
		{ aquaman, batman, wonderwoman, superman, birdman };
		FlyingHero[] flyingHeroes = new FlyingHero[]
		{ superman, birdman };

		// All heroes
		for (SuperHero superhero : superHeroes)
			superhero.saveTheWorld();

		// FlyingHeroes only
		for (FlyingHero flyingHero : flyingHeroes)
			flyingHero.fly();

		System.out.println();
	}

	// flying birds and heroes together!
	public void combinedFly()
	{
		// only used locally
		Flyer eagle = new Eagle();
		Flyer parrot = new Parrot();

		// all of the flyers combined
		Flyer[] flyers = new Flyer[]
		{ eagle, parrot, superman, birdman };

		for (Flyer flyer : flyers)
			flyer.fly();

		System.out.println();
	}
}
