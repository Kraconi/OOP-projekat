package projekatzadatak3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Shape;
import geometry.rectangle;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import projekatzadatak3.PnlDrawing;
import javax.swing.JTextField;

public class FrmDraw extends JFrame {

	private JPanel contentPane;
	public final ButtonGroup buttonGroupTop = new ButtonGroup();
	public final ButtonGroup buttonGroupBottom = new ButtonGroup();
	private PnlDrawing pnlDrawing=new PnlDrawing(this);
	
	private JToggleButton tglbtnSelect=new JToggleButton("Select");
	
	private JToggleButton tglbPoint=new JToggleButton("Point");
	private JToggleButton tglbLine=new JToggleButton("Line");
	private JToggleButton tglbCircle=new JToggleButton("Circle");
	private JToggleButton tglbRectangle=new JToggleButton("Rectangle");
	private JToggleButton tglbDonut=new JToggleButton("Donut");

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDraw frame = new FrmDraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDraw() {
		setTitle("StefanVidicIT70/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel North = new JPanel();
		contentPane.add(North, BorderLayout.NORTH);
		GridBagLayout gbl_North = new GridBagLayout();
		gbl_North.columnWidths = new int[]{71, 69, 0, 81, 75, 0};
		gbl_North.rowHeights = new int[]{0, 0};
		gbl_North.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_North.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		North.setLayout(gbl_North);
		North.setBackground(Color.BLUE);
		
		buttonGroupTop.add(tglbPoint);
		buttonGroupTop.add(tglbLine);
		buttonGroupTop.add(tglbRectangle);
		buttonGroupTop.add(tglbCircle);
		buttonGroupTop.add(tglbDonut);
		
		North.add(tglbPoint);
		North.add(tglbLine);
		North.add(tglbRectangle);
		North.add(tglbCircle);
		North.add(tglbDonut);
		
		pnlDrawing.setBackground(Color.WHITE);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		South.setBackground(Color.BLUE);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getSelectedShape()!=null) 
				{
					modify();
				}else 
				{
					JOptionPane.showMessageDialog(null, "Select what you want to modify!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				pnlDrawing.setSelectedShape(null);
				tglbtnSelect.setSelected(false);
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getSelectedShape()!=null) 
				{
					delete();
				}else 
				{
					JOptionPane.showMessageDialog(null, "Select what you want to delete!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				pnlDrawing.setSelectedShape(null);
				tglbtnSelect.setSelected(false);
			}
		});
		
		South.add(btnModify);
		South.add(btnDelete);
		South.add(tglbtnSelect);
		
		buttonGroupBottom.add(btnDelete);
		buttonGroupBottom.add(btnModify);
		
	}
	protected void modify() 
	{
		Shape shape=pnlDrawing.getSelectedShape();
		if(shape instanceof Point) 
		{
			Point point=(Point)shape;
			DlgPoint dlg=new DlgPoint();
			dlg.txtX.setText(point.getX() + "");
			dlg.txtY.setText(point.getY() + "");
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
			pnlDrawing.getShapes().remove(shape);
			pnlDrawing.getShapes().add(dlg.getPoint());
			repaint();
			}
		}else if(shape instanceof Line) 
		{
			Line line=(Line) shape;
			DlgLine dlg=new DlgLine();
			dlg.txtXStart.setText(line.getStartPoint().getX() + "");
			dlg.txtYStart.setText(line.getStartPoint().getY() + "");
			dlg.txtXEnd.setText(line.getEndPoint().getX() + "");
			dlg.txtYEnd.setText(line.getEndPoint().getY() + "");
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
			pnlDrawing.getShapes().remove(shape);
			pnlDrawing.getShapes().add(dlg.getLine());
			repaint();
			}
		}else if(shape instanceof rectangle) 
		{
			rectangle rect=(rectangle) shape;
			DlgRectangle dlg=new DlgRectangle();
			dlg.txtX.setText(rect.getUpperLeft().getX() + "");
			dlg.txtY.setText(rect.getUpperLeft().getY() + "");
			dlg.txtWidth.setText(rect.getWidth() + "");
			dlg.txtHeight.setText(rect.getHeight() + "");
			dlg.btnInnerColor.setBackground(rect.getInnerColor());
			dlg.btnOutlineColor.setBackground(rect.getColor());
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
			pnlDrawing.getShapes().remove(shape);
			pnlDrawing.getShapes().add(dlg.getRectangle());
			repaint();			
			}
		}else if(shape instanceof Circle) 
		{
			Circle circle=(Circle) shape;			
			DlgCircle dlg=new DlgCircle();
			dlg.txtX.setText(circle.getCenter().getX() + "");
			dlg.txtY.setText(circle.getCenter().getY() + "");
			dlg.txtRadius.setText(circle.getRadius() + "");
			dlg.btnInnerColor.setBackground(circle.getInnerColor());
			dlg.btnOutlineColor.setBackground(circle.getColor());
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
			pnlDrawing.getShapes().remove(shape);
			pnlDrawing.getShapes().add(dlg.getCircle());
			repaint();
			}
		}else if(shape instanceof Donut) 
		{
			Donut donut=(Donut) shape;
			DlgDonut dlg=new DlgDonut();
			dlg.txtX.setText(donut.getCenter().getX() + "");
			dlg.txtY.setText(donut.getCenter().getY() + "");
			dlg.txtRadius.setText(donut.getRadius() + "");
			dlg.txtInner.setText(donut.getInnerRadius() + "");
			dlg.btnInnerColor.setBackground(donut.getInnerColor());
			dlg.btnOutlineColor.setBackground(donut.getColor());
			dlg.setModal(true);
			dlg.setVisible(true);
			if(dlg.isOK==true) 
			{
			pnlDrawing.getShapes().remove(shape);
			pnlDrawing.getShapes().add(dlg.getDonut());
			repaint();
			}
		}
	}
	protected void delete() 
	{
			Shape shape=pnlDrawing.getSelectedShape();
			int opinion=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this object?","Confirm delete",
					JOptionPane.YES_NO_OPTION);
			if(opinion==JOptionPane.YES_OPTION) 
			{
			pnlDrawing.getShapes().remove(shape);
			repaint();
			}
	}
	
	public JToggleButton getTglButtonPoint() 
	{
		return tglbPoint;
	}
	public void setTglButtonPoint(JToggleButton n) 
	{
		this.tglbPoint=n;
	}
	
	public JToggleButton getTglButtonLine() 
	{
		return tglbLine;
	}
	public void setTglButtonLine(JToggleButton n) 
	{
		this.tglbLine=n;
	}
	
	public JToggleButton getTglButtonCircle() 
	{
		return tglbCircle;
	}
	public void setTglButtonCircle(JToggleButton n) 
	{
		this.tglbCircle=n;
	}
	
	public JToggleButton getTglButtonDonut() 
	{
		return tglbDonut;
	}
	public void setTglButtonDonut(JToggleButton n) 
	{
		this.tglbDonut=n;
	}
	
	public JToggleButton getTglButtonRectangle() 
	{
		return tglbRectangle;
	}
	public void setTglButtonRectangle(JToggleButton n) 
	{
		this.tglbRectangle=n;
	}
	
	public JToggleButton getTglButtonSelect() 
	{
		return tglbtnSelect;
	}
	public void setTglButtonSelect(JToggleButton n) 
	{
		this.tglbtnSelect=n;
	}
}
