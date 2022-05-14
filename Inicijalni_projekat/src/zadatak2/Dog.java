package zadatak2;

public class Dog extends Animal{
	private boolean hungry;
	
	public boolean isHungry() 
	{
		return hungry;
	}
	public void setHungry(boolean hungry) 
	{
		this.hungry=hungry;
	}
	
	public Dog() {}
	public Dog(String name,String breed,boolean hungry) 
	{
		super(name,breed);
		setHungry(hungry);
	}
	
	void feed() {
		if(this.hungry=true) 
		{
			this.hungry=false;
			System.out.println(this.getName() + " is full and happy!");
		}else System.out.println(this.getName() + "burries food for rainy days!");
	}

	void namePet(String name) {
		this.setName(name);
	}

	void respond() {
		System.out.println("woof woof");
	}

	public String toString() 
	{
		return "name:" + this.getName() + ",race:" + this.getBreed() + ",hungry:" + this.isHungry();
	}
	
	public static int calculateHumanYears(int dogYears) 
	{
		return dogYears*15;
	}
	
}
