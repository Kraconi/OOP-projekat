package geometry;

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
		System.out.println("Line L1 start point" + L1.getStartPoint().getX()+","+L1.getEndPoint().getY());
				
		//Postaviti y kordinatu krajnje tacke L1 na 23
		
		L1.getEndPoint().setY(23);
		
	}
}
