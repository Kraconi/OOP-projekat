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
	public static ArrayList<Shape> dlm=new ArrayList<Shape>();
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public static int n=0;
	public static Point gen=new Point();
	private JTextField txtTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDraw frame = new FrmDraw();
					frame.setVisible(true);
					ArrayList<Shape> dlm = new ArrayList<Shape>();
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
		setBounds(100, 100, 743, 479);
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
		
		JToggleButton tglbPoint = new JToggleButton("Point");
		tglbPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPoint dlg=new DlgPoint();
				n=1;
			}
		});
		buttonGroup.add(tglbPoint);
		GridBagConstraints gbc_tglbPoint = new GridBagConstraints();
		gbc_tglbPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbPoint.gridx = 0;
		gbc_tglbPoint.gridy = 0;
		North.add(tglbPoint, gbc_tglbPoint);
		
		JToggleButton tglbLine = new JToggleButton("Line");
		tglbLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n=2;
			}
		});
		buttonGroup.add(tglbLine);
		GridBagConstraints gbc_tglbLine = new GridBagConstraints();
		gbc_tglbLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbLine.gridx = 1;
		gbc_tglbLine.gridy = 0;
		North.add(tglbLine, gbc_tglbLine);
		
		JToggleButton tglbRect = new JToggleButton("Rectangle");
		tglbRect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n=3;
			}
		});
		buttonGroup.add(tglbRect);
		GridBagConstraints gbc_tglbRect = new GridBagConstraints();
		gbc_tglbRect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbRect.gridx = 2;
		gbc_tglbRect.gridy = 0;
		North.add(tglbRect, gbc_tglbRect);
		
		JToggleButton tglbCircle = new JToggleButton("Circle");
		tglbCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n=4;
			}
		});
		buttonGroup.add(tglbCircle);
		GridBagConstraints gbc_tglbCircle = new GridBagConstraints();
		gbc_tglbCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbCircle.gridx = 3;
		gbc_tglbCircle.gridy = 0;
		North.add(tglbCircle, gbc_tglbCircle);
		
		JToggleButton tglbDonut = new JToggleButton("Donut");
		tglbDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n=5;
			}
		});
		buttonGroup.add(tglbDonut);
		GridBagConstraints gbc_tglbDonut = new GridBagConstraints();
		gbc_tglbDonut.gridx = 4;
		gbc_tglbDonut.gridy = 0;
		North.add(tglbDonut, gbc_tglbDonut);
		
		PnlDrawing Center = new PnlDrawing();
		Center.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gen.setX(e.getX());
				gen.setY(e.getY());
				dlm.add(gen);
				txtTest.setText(gen.toString());
			}
		});
		contentPane.add(Center, BorderLayout.CENTER);
		Center.setForeground(Color.PINK);
		Center.setBackground(Color.PINK);
		
		txtTest = new JTextField();
		Center.add(txtTest);
		txtTest.setColumns(10);
		txtTest.setText("0,0");
		
		JPanel South = new JPanel();
		contentPane.add(South, BorderLayout.SOUTH);
		South.setForeground(Color.BLACK);
		South.setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("New button");
		South.add(btnNewButton);
		
	}

}
