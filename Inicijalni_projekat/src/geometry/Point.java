package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;
	
	public double distance(int x2,int y2) {
		double dx=x-x2;
		double dy=y-y2;
		double d=Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	//metode pristupa
	//get i set metode 
	
	public int getX() {
		return x;//moze i return this.x isto je 
	}
	public void setX(int x) {
		this.x=x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	//konstruktor
	
	public Point() {}
	public Point(int x,int y) 
	{
		this.x=x;
		this.y=y;
	}
	public Point(int x,int y,boolean selected) 
	{
		this(x,y);
		setSelected(selected);
	}
	public boolean contains(int x,int y) 
	{
		return this.distance(x, y) <= 2;
	}
	
	public String toString() 
	{
		return "(" + x + "," + y + ")"; 
	}
	
	public boolean equals(Object obj) 
	{
		if (obj instanceof Point) 
		{
			Point pomocna = (Point) obj;
			if(this.x==pomocna.getX() && this.y==pomocna.getY()) 
			{
				return true;
			}else {return false;}
		}else {return false;}
		
	}

	@Override
	public void draw(Graphics g) {//tacku na crtezu predstavljmoa sa krstom,tj dve linije,jedna vertikalna i jedna horizontalna
		g.setColor(Color.BLACK);
		g.drawLine(x-2, y, x+2, y);//horizontalna linija
		g.drawLine(x, y-2, x, y+2);//vertikalna linija
		if(isSelected()) 
		{
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x=x;
		this.y=y;
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		this.x=this.x + byX;
		this.y += byY;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Point) 
		{
			return (int)(this.distance(0, 0)-((Point)obj).distance(0, 0));
		}
		return 0;
	}
}
