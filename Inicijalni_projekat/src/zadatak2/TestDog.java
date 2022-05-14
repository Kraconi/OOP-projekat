package zadatak2;

public class TestDog {

	public static void main(String[] args) {
		Dog dog1=new Dog("Bethoven","St.Bernard",false);
		Dog dog2=new Dog("Boby","Badger dog",true);
		
		dog1.feed();
		
		System.out.println(dog1);
		System.out.println(dog2);
		System.out.print(Dog.calculateHumanYears(3));
	}

}
