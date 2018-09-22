package library;

// from topic4
public abstract class AbstractMedia implements Media
{
	private Integer id;

	@Override
	public Integer getId()
	{
		return id;
	}

	@Override
	public void setId(Integer id)
	{
		this.id = id;
	}
}