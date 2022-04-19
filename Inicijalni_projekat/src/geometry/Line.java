package geometry;

import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	
	//Metoda za duzinu linije
	public double length() {
		return startPoint.distance(endPoint.getX(),endPoint.getY());
	}
	
	
	///Metode pristupa
	public Point getStartPoint() {return startPoint;}
	public void setStartPoint(Point startPoint) 
	{
	this.startPoint=startPoint;	
	}
	
	
	public Point getEndPoint() {return endPoint;}
	public void setEndPoint(Point endPoint) 
	{
	this.endPoint=endPoint;	
	}
	
	public Line() {}
	public Line(Point startPoint,Point endPoint) 
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	public Line(Point startPoint,Point endPoint,boolean selected) 
	{
		this(startPoint,endPoint);
		setSelected(selected);
	}
	public boolean contains(int x,int y) 
	{
		return startPoint.distance(x, y)+endPoint.distance(x, y) - length()<=2;
	}
	public String toString() 
	{
		return startPoint + "-->" + endPoint;
	}
	public boolean equals(Object obj) 
	{
		if(obj instanceof Line) 
		{
			Line pomocna = (Line) obj;
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
			{
				return true;
			}else return false;
		}else return false;
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY());
	}
	
}

