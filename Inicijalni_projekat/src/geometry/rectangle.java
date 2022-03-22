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
	
	//Metode pristuap
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
}
