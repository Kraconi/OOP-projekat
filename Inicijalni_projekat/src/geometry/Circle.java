package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	private Point center;
	private int radius;


	public Point getCenter()
	{
		return center;
	}
	public void setCenter(Point x) 
	{
		this.center=x;
	}
	
	public int getRadius() 
	{
		return radius;
	}
	public void setRadius(int x) throws Exception 
	{
		if(x<0) 
		{
			throw new Exception("Radius ne moze biti manji od 0!");
		}
		this.radius=x;
	}
	
	
	public Circle() {}
	public Circle(Point center,int radius) 
	{
		this.center=center;
		this.radius=radius;
	}
	public Circle(Point center,int radius,boolean selected) 
	{
		this(center,radius);
		setSelected(selected);
	}
	public String toString() 
	{
		return " Center point=" + center + " Radius=" + radius; 
	}
	public boolean equals(Object obj) 
	{
		if(obj instanceof Circle) 
		{
			Circle pomocni = (Circle)obj;
			if(pomocni.getCenter().equals(this.center)&& pomocni.getRadius()==this.radius)
				return true;
			return false;
		}
		return false;
	}
	
	public boolean contains(int x,int y) 
	{
		return center.distance(x, y)<=radius;
	}
	public boolean contains(Point p) 
	{
		return center.distance(p.getX(),p.getY())<=radius;
	}
	
	public double circumference() 
	{
		return 2*radius*Math.PI;
	}
	public double area() 
	{
		return radius*radius*Math.PI;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawOval(center.getX()-radius,center.getY()-radius, radius*2, radius*2);
		if(isSelected()) 
		{
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-2,center.getY()-2, 4, 4);
			g.drawRect(center.getX()-2,center.getY()-radius-2, 4, 4);
			g.drawRect(center.getX()-2,center.getY()+radius-2, 4, 4);
			g.drawRect(center.getX()-2+radius,center.getY()-2, 4, 4);
			g.drawRect(center.getX()-2-radius,center.getY()-2, 4, 4);
		}
	}
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		center.moveTo(x, y);
	}
	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		center.moveBy(byX, byY);
	}
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) 
		{
			return (int)(this.area()-((Circle)obj).area());
		}
		return 0;
	}
}