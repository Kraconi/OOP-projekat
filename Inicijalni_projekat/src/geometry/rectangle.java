package geometry;

public class rectangle {
	
	private Point upperLeft;
	private int width;
	private int height;
	private boolean selected;
	
	public int area(int x,int y)
	{
		return width *height;
	}
	
	public int circumference(int x,int y)
	{
		return 2*width+2*height;
	}
	
	//Metode pristupa
	public Point getUpperLeft() {return upperLeft;}
	public void setUpperLeft(Point upperLeft) 
	{
		this.upperLeft=upperLeft;
	}
	
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width=width;
	}
	
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height=height;
	}
	
	public boolean isSelected() 
	{
		return selected;
	}
	public void setSelected(boolean selected) 
	{
		this.selected=selected;
	}
	
	public rectangle(){}
	
	public rectangle(Point upperLeft,int x,int y) 
	{
		this.upperLeft=upperLeft;
		this.width=x;
		this.height=y;
	}
	public rectangle(Point upperLeft,int x,int y,boolean selected) 
	{
		this(upperLeft,x,y);
		this.selected=selected;
	}
	public boolean contains(int x,int y) 
	{
		return upperLeft.getX() < x && upperLeft.getX() + width > x && upperLeft.getY()< y && upperLeft.getY()+ height > y;
	}
	public boolean contains(Point p) 
	{
		return upperLeft.getX() < p.getX() && upperLeft.getX() + width > p.getX() && upperLeft.getY()< p.getY() && upperLeft.getY()+ height > p.getY();
	}
	public String toString() 
	{
		return "Upper left point:"+ upperLeft + " ," + "width=" + width + ", " + "height=" + height; 
	}
	public boolean equals(Object obj) 
	{
		if(obj instanceof rectangle)
		{
			rectangle pomocni =(rectangle) obj;
			if(this.upperLeft.equals(pomocni.upperLeft) && this.width==pomocni.width && this.height==pomocni.height ) 
			{return true;
			}else return false;
		}else return false;
	}
}
