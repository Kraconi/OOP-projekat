package geometry;

public class Circle {
	
	private Point center;
	private int radius;
	private boolean selected;


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
	public void setRadius(int x) 
	{
		this.radius=x;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected=selected;
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
		this.selected=selected;
	}
	public String toString() 
	{
		return "Center point=" + center + " Radius=" + radius; 
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
}