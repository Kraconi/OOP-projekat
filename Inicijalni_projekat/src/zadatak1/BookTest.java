package zadatak1;

public class BookTest {

	public static void main(String[] args) {
		Book bookOne=new Book();
		Book bookTwo=new Book("Digital Fortress","Dan Brown",445,900.00);
		bookOne.setName("Inferno");
		bookOne.setAuthor("Dan Brown");
		bookOne.setNumberOfPages(445);
		bookOne.setPrice(950.00);
		System.out.println(bookOne.calculateDiscountPrice(15));
		bookTwo.setPrice(bookTwo.calculateDiscountPrice(20));
		bookOne.setPrice(bookOne.calculateDiscountPrice(15));
		if(bookTwo.getPrice()>bookOne.getPrice()) 
		{
			System.out.println(bookOne.getName());
		}else System.out.println(bookTwo.getName());
	}


}
