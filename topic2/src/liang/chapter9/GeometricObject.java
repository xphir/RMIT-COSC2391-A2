package liang.chapter9;

public class GeometricObject
{
	private String color = "white";

	private boolean filled;

	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	public GeometricObject()
	{
		this(new java.util.Date());
		filled = true;
	}

	public GeometricObject(String color)
	{
		this(); // added by caspar since date created must always be set
		this.color = color;
	}

	public GeometricObject(java.util.Date date)
	{
		dateCreated = date;
	}

	public GeometricObject(java.util.Date date, String color)
	{
		this(date);
		this.color = color;
	}

	public GeometricObject(java.util.Date date, String color, boolean filled)
	{
		this(date, color);
		this.filled = filled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chapter9.GeometricObject#getColor()
	 */
	public String getColor()
	{
		return color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chapter9.GeometricObject#setColor(java.lang.String)
	 */
	public void setColor(String color)
	{
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chapter9.GeometricObject#isFilled()
	 */
	public boolean isFilled()
	{
		return filled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chapter9.GeometricObject#setFilled(boolean)
	 */
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chapter9.GeometricObject#getDateCreated()
	 */
	public java.util.Date getDateCreated()
	{
		return dateCreated;
	}

	/** Return a string representation of this object */
	@Override
	public String toString()
	{
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
		// return super.toString();
	}

	// public double getArea()
	// {
	// return 0.0;
	// }
}
