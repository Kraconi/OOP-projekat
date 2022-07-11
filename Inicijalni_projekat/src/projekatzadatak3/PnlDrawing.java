package projekatzadatak3;

import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;
import geometry.Line;
import geometry.Circle;
import geometry.Donut;
import geometry.rectangle;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.border.LineBorder;


public class PnlDrawing extends JPanel {
	
	private FrmDraw frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint=null;
	protected Shape selectedShape;
	
	public PnlDrawing() {
	}
	
	public PnlDrawing(FrmDraw frame) 
	{
		this.frame=frame;
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				MouseClicked(me);
			}
		});
	}
	
	public void MouseClicked(MouseEvent n) 
	{
		Shape shape=null;
		Point click=new Point(n.getX(),n.getY());
		if(frame.getTglButtonSelect().isSelected()) 
		{
			selectedShape = null;
			Iterator<Shape> iterator = shapes.iterator();
			while(iterator.hasNext()) 
			{
				shape=iterator.next();
				shape.setSelected(false);
				if(shape.contains(click.getX(), click.getY()))
						{
							selectedShape=shape;
						}
			}
			if(selectedShape != null) 
			{
				selectedShape.setSelected(true);
			}
		}else if(frame.getTglButtonPoint().isSelected()) 
		{
		shape=new Point(click.getX(),click.getY(),false);
		}else if(frame.getTglButtonLine().isSelected()) 
		{
			
			if(startPoint==null) 
			{
				startPoint=click;
			}else	
			{
				Point end=new Point(click.getX(),click.getY(),false);
				shape=new Line(startPoint,end,false);
				startPoint=null;
			}
			
		}else if(frame.getTglButtonRectangle().isSelected()) 
			
		{
			DlgRectangle dlg=new DlgRectangle();
			dlg.txtX.setText(n.getX() + "");
			dlg.txtY.setText(n.getY() + "");
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
				shape=dlg.getRectangle();
			}
		}else if(frame.getTglButtonCircle().isSelected())
		
		{
			DlgCircle dlg=new DlgCircle();
			dlg.txtX.setText(n.getX() + "");
			dlg.txtY.setText(n.getY() + "");
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
				shape=dlg.getCircle();
			}
		}else if(frame.getTglButtonDonut().isSelected()) 
		{
			DlgDonut dlg=new DlgDonut();
			dlg.txtX.setText(n.getX() + "");
			dlg.txtY.setText(n.getY() + "");
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
				shape=dlg.getDonut();
			}
		}
		
		if(shape != null) 
		{
			shapes.add(shape);
		}
		repaint();
		}
	public void paint(Graphics g) 
	{
		super.paint(g);
		Iterator<Shape>it=shapes.iterator();
		while(it.hasNext()) 
		{
			it.next().draw(g);
		}
	}
	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	}

