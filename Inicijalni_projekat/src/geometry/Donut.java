package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {}
	public Donut(Point center,int radius,int innerRadius) 
	{
		super(center,radius);
		///setCenter(center);
		///setRadius(radius);
		this.innerRadius=innerRadius;
	}
	public Donut(Point center,int radius,int innerRadius,boolean selected) 
	{
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) { 
		this(center, radius, innerRadius, selected);
		setColor(color);
		setInnerColor(innerColor);
	}
	public void setInnerRadius(int innerRadius) 
	{
		this.innerRadius=innerRadius;
	}
	public int getInnerRadius() 
	{
		return innerRadius;
	}
	public double area() 
	{
		return super.area()-innerRadius*innerRadius*Math.PI;
	}
	public boolean contains(int x,int y) 
	{
		return super.contains(x, y) && getCenter().distance(x, y)>innerRadius;
	}
	public boolean contains(Point p) 
	{
		return super.contains(p) && getCenter().distance(p.getX(),p.getY())>innerRadius;
	}
	public String toString() 
	{
		return super.toString() + " InnerRadius=" + innerRadius;
	}
	public boolean equals(Object obj) 
	{
		if(obj instanceof Donut) 
		{
			Donut pomocni=(Donut)obj;
			if(pomocni.getCenter().equals(getCenter()) && pomocni.getRadius()==getRadius() && pomocni.innerRadius==innerRadius)
				return true;
			return false;
		}return false;
	}
	
	public void fill(Graphics g) 
	{
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - this.innerRadius +1, getCenter().getY() - this.innerRadius+1, this.innerRadius * 2-2, this.innerRadius * 2-2);
	}
	public void draw(Graphics g) 
	{
		super.draw(g);///spoljasnji krug
		g.drawOval(getCenter().getX()-innerRadius,getCenter().getY()-innerRadius,innerRadius*2,innerRadius*2);//unutrasnji krug
		if(isSelected()) 
		{
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX()-2,getCenter().getY()-innerRadius-2, 4, 4);
			g.drawRect(getCenter().getX()-2,getCenter().getY()+innerRadius-2, 4, 4);
			g.drawRect(getCenter().getX()-2+innerRadius,getCenter().getY()-2, 4, 4);
			g.drawRect(getCenter().getX()-2-innerRadius,getCenter().getY()-2, 4, 4);
		}
	}
	public int compareTo(Object obj) 
	{
		if(obj instanceof Donut) 
		{
			return (int)(this.area()-((Donut)obj).area());
		}return 0;
	}
}
