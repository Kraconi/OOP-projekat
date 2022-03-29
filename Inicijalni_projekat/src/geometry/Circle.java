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
	
	public double circumference(int rad) 
	{
		return 2*rad*Math.PI;
	}
	public double area(int rad) 
	{
		return rad*rad*Math.PI;
	}
}