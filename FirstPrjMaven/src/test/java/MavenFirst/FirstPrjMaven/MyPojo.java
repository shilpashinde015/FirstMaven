package MavenFirst.FirstPrjMaven;


public class MyPojo
{
	private String id;
	
	private String lastName;
	
	private String trusted;
	
	private String[] apartments;
	
	private String firstName;

	public String getId ()
	{
		return id;
	}
	
	public void setId (String id)
	{
		this.id = id;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	
	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getTrusted ()
	{
		return trusted;
	}
	
	public void setTrusted (String trusted)
	{
		this.trusted = trusted;
	}
	
	public String[] getApartments ()
	{
		return apartments;
	}
	
	public void setApartments (String[] apartments)
	{
		this.apartments = apartments;
	}
	
	public String getFirstName ()
	{
		return firstName;
	}
	
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [id = "+id+", lastName = "+lastName+", trusted = "+trusted+", apartments = "+apartments+", firstName = "+firstName+"]";
	}
}