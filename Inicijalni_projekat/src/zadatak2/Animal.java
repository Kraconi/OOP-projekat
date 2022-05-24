package zadatak2;

public abstract class Animal {
	private String name;
	private String breed;
	
	public void setName(String name) 
	{
		this.name=name;
	}
	public String getName() 
	{
		return this.name;
	}
	
	public void setBreed(String breed) 
	{
		this.breed=breed;
	}
	public String getBreed() 
	{
		return this.breed;
	}
	
	abstract void feed();
	abstract void namePet(String name);
	abstract void respond();
	
	public Animal() {}
	public Animal(String name,String breed) 
	{
		this.name=name;
		this.breed=breed;	
	}
}
