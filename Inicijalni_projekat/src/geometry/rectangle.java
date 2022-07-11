package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class rectangle extends SurfaceShape {
	
	private Point upperLeft;
	private int width;
	private int height;
	
	public double area()
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
		setSelected(selected);
	}
	public rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint,width,height,selected);
		setColor(color);
		setInnerColor(innerColor);
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

	public void fill(Graphics g) 
	{
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeft.getX()+1, this.getUpperLeft().getY()+1, width-1, height-1);
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(),upperLeft.getY(), width, height);
		this.fill(g);
		if(isSelected()) 
		{
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX()-2,upperLeft.getY()-2 ,4, 4);
			g.drawRect(upperLeft.getX()-2+width,upperLeft.getY()-2 ,4, 4);
			g.drawRect(upperLeft.getX()-2,upperLeft.getY()-2+height ,4, 4);
			g.drawRect(upperLeft.getX()-2+width,upperLeft.getY()-2+height ,4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		upperLeft.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		upperLeft.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof rectangle) 
		{
			return (int)(this.area()-((rectangle)obj).area());
		}
		return 0;
	}
}
