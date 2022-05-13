package geometry;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		p.setX(6);
		p.setY(5);
		p.setSelected(true);
		
		System.out.println("X cordinate:" + p.getX() +" Y cordinate:"+p.getY() + " Selected:" + p.isSelected());
		
		Point p1 = new Point();
		p1.setX(2);
		p1.setY(3);
		p1.setSelected(true);
		
		double result=p.distance(2, 2);
		System.out.println("Distance between points is " + result);
		
		Line L1=new Line();
		rectangle R1=new rectangle();
		
		//Inicajalizovati x kordiant tacke p na vr y kordinate tacke p1
		p.setX(p1.getY());
		System.out.println("Point P,x cordinate:" + p.getX());
		
		//Postaviti za pocetnu tacku linije l1 tacku p,a krajnju tacku linije l1 tacku p1
		L1.setStartPoint(p);
		L1.setEndPoint(p1);
		System.out.println("Line L1 start point " + L1.getStartPoint().getX()+","+L1.getEndPoint().getY());
				
		//Postaviti y kordinatu krajnje tacke L1 na 23
		
		L1.getEndPoint().setY(23);
		
		Point p2=new Point(50,100);
		Circle c1=new Circle(p1,10);
		Line L2=new Line(p2,new Point(400,500));
		rectangle R2=new rectangle(p1,50,80);
		
		System.out.println(p2);
		System.out.println(p1);
		System.out.println(L2);
		System.out.println(R2);
		
		System.out.println(p2.equals(p1));
		System.out.println(p2.equals(L2));
		
		p1.setX(50);
		p1.setY(100);
		System.out.println(p2.equals(p1));
		
		System.out.println(p2 instanceof Point);
		System.out.println(p2 instanceof Object);
		
		System.out.println("\nVezbe 7");
		
		System.out.println(p1);
		p1.moveBy(5, 3);
		System.out.println(p1);
		p1.moveTo(5, 3);
		System.out.println(p1);
		
		System.out.println(L1);
		L1.moveTo(1, 1);
		System.out.println(L1);
		L1.moveBy(1, 1);
		System.out.println(L1);
		
		////System.out.println(c1);
		////c1.moveBy(1,1);
		////System.out.println(c1);
		////c1.moveTo(1,1);
		////System.out.println(c1);
		
		int[] numbers= {5,4,3,7,2,1};
		System.out.println("\nNesortirani niz");
		for(int i=0;i<numbers.length;i++) 
		{
			System.out.println(numbers[i]);
		
		}
		
		Arrays.sort(numbers);
		System.out.println("\nSortirani niz");
		for(int i=0;i<numbers.length;i++) 
		{
			System.out.println(numbers[i]);
		}
		
		//Arrays.toString(numbers);
		//System.out.println("\nNiz u jednom redu");
		//for(int i=0;i<numbers.length;i++) 
		//{
		//	System.out.println(numbers[i]);
		//}
		Point p10=new Point(10,10);
		Point p20=new Point(20,20);
		Point p30=new Point(30,30);
		Point p40=new Point(140,140);
		Point p50=new Point(5,5);
		
		Point[] points= {p10,p20,p30,p40,p50};
		System.out.println("\nNesortiran niz tacaka");
		for(int i=0;i<points.length;i++) 
		{
			System.out.println(points[i]);
		}
		Arrays.sort(points);
		System.out.println("Sortiran niz tacaka");
		for(int i=0;i<points.length;i++) 
		{
			System.out.println(points[i]);
		}
		
		Circle c10=new Circle(p10,10);
		Circle c20=new Circle(p20,20);
		Circle c30=new Circle(p30,3);
		Circle[] circles= {c10,c20,c30};
		System.out.println("\nNesortiran niz krugova");
		for(int i=0;i<circles.length;i++) 
		{
			System.out.println(circles[i]);
		}
		Arrays.sort(circles);
		System.out.println("Sortiran niz krugova");
		for(int i=0;i<circles.length;i++) 
		{
			System.out.println(circles[i]);
		}
	}
}
