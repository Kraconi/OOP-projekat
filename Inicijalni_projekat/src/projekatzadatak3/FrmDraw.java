package projekatzadatak3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Shape;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel North = new JPanel();
		contentPane.add(North, BorderLayout.NORTH);
		GridBagLayout gbl_North = new GridBagLayout();
		gbl_North.columnWidths = new int[]{71, 69, 0, 0, 0, 0};
		gbl_North.rowHeights = new int[]{0, 0};
		gbl_North.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_North.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		North.setLayout(gbl_North);
		North.setBackground(Color.BLUE);
		
		JToggleButton tglbPoint = new JToggleButton("Point");
		tglbPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupTop.add(tglbPoint);
		GridBagConstraints gbc_tglbPoint = new GridBagConstraints();
		gbc_tglbPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbPoint.gridx = 0;
		gbc_tglbPoint.gridy = 0;
		North.add(tglbPoint, gbc_tglbPoint);
		
		JToggleButton tglbLine = new JToggleButton("Line");
		tglbLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupTop.add(tglbLine);
		GridBagConstraints gbc_tglbLine = new GridBagConstraints();
		gbc_tglbLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbLine.gridx = 1;
		gbc_tglbLine.gridy = 0;
		North.add(tglbLine, gbc_tglbLine);
		
		JToggleButton tglbRect = new JToggleButton("Rectangle");
		tglbRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupTop.add(tglbRect);
		GridBagConstraints gbc_tglbRect = new GridBagConstraints();
		gbc_tglbRect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbRect.gridx = 2;
		gbc_tglbRect.gridy = 0;
		North.add(tglbRect, gbc_tglbRect);
		
		JToggleButton tglbCircle = new JToggleButton("Circle");
		tglbCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupTop.add(tglbCircle);
		GridBagConstraints gbc_tglbCircle = new GridBagConstraints();
		gbc_tglbCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbCircle.gridx = 3;
		gbc_tglbCircle.gridy = 0;
		North.add(tglbCircle, gbc_tglbCircle);
		
		JToggleButton tglbDonut = new JToggleButton("Donut");
		tglbDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroupTop.add(tglbDonut);
		GridBagConstraints gbc_tglbDonut = new GridBagConstraints();
		gbc_tglbDonut.gridx = 4;
		gbc_tglbDonut.gridy = 0;
		North.add(tglbDonut, gbc_tglbDonut);
		
		pnlDrawing.setBackground(Color.PINK);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		South.setBackground(Color.BLUE);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		South.add(tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		South.add(tglbtnDelete);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		South.add(tglbtnSelect);
		
		buttonGroupBottom.add(tglbtnSelect);
		buttonGroupBottom.add(tglbtnDelete);
		buttonGroupBottom.add(tglbtnModify);
		
		
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
