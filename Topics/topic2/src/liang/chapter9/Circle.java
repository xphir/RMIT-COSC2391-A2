package liang.chapter9;

import java.util.Date;

public class Circle extends GeometricObject
{
	private double radius;

	public Circle()
	{
		this(1.0);
	}

	public Circle(Date date, String color, boolean filled, double radius)
	{
		this(date, color, radius, filled);
	}

	public Circle(Date date, String color, double radius, boolean filled)
	{
		super(date, color, filled);
		this.radius = radius;
	}

	public Circle(double radius)
	{
		//super(); // will be invoked automatically anyway
		this.radius = radius;
	}

	/** Return radius */
	public double getRadius()
	{
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	/** Return area */
	public double getArea()
	{
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter()
	{
		return 2 * radius;
	}

	/** Return perimeter */
	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

	/** Print the circle info */
	public void printCircle()
	{
		System.out.println("The circle is created " + super.getDateCreated() + " and the radius is " + radius);
	}

	// added by Caspar as an example of over-riding
	public Date getDateCreated()
	{
		// use the superclass behaviour
		Date created = super.getDateCreated();

		// but do something specialised
		Date now = new java.util.Date();

		if (now.compareTo(created) != 0)
			return now;
		else
			return created;
	}

	@Override
	// added by Caspar for polymorphism demo
	public String toString()
	{
		// pasted from printCircle();
		return "The circle was " + super.toString() + " and the radius is " + radius;
	}
}
