package zadatak1;

public class Book {
	private String name;
	private String author;
	private int numberOfPages;
	private double price;
	
	public Book() {}
	public Book(String name,String author,int numberOfPages) 
	{
		this.name=name;
		this.author=author;
		this.numberOfPages=numberOfPages;
	}
	public Book(String name,String author,int numberOfPages,double price) 
	{
		this(name,author,numberOfPages);
		this.price=price;
	}
	public void setName(String x) 
	{
		this.name=x;
	}
	public String getName() 
	{
		return name;
	}
	public void setAuthor(String x) 
	{
		this.author=x;
	}
	public String getAuthor() 
	{
		return author;
	}
	public void setNumberOfPages(int x) 
	{
		if(x<0) 
		{
			System.out.println("Uneta vrednost mora biti pozitivna!");
		}else this.numberOfPages=x;
	}
	public int getNumberOfPages() 
	{
		return numberOfPages;
	}
	public void setPrice(double x) 
	{
		if(x<0) 
		{
			System.out.println("Uneta vrednost mora biti pozitivna!");
		}else this.price=x;
	}
	public double getPrice() 
	{
		return price;
	}
	private double calculateDiscount(int x) 
	{
		double f=this.price*x/100;
		return f;
	}
	public double calculateDiscountPrice(int x) 
	{
		double f=this.price-calculateDiscount(x);
		return f;
	}
	
}
