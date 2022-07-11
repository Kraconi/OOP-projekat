package projekatzadatak1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm=new DefaultListModel<Circle>();
	private JList lstStack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
		setTitle("StefanVidic-IT70/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 0, 50, 50, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgPush dlgPush=new DlgPush();
				try {
				dlgPush.setVisible(true);
				if(dlgPush.isOK==true) 
				{
					int r=Integer.parseInt(dlgPush.txtRadius.getText());
					if(r<0){throw new IllegalArgumentException();}
					int x=Integer.parseInt(dlgPush.txtX.getText());
					int y=Integer.parseInt(dlgPush.txtY.getText());
					Point p=new Point(x,y);
					Circle C=new Circle(p,r);
					dlm.add(0,C);
				}
				}catch(java.lang.NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "All valuse must be eneter and must be numbers!","Error",
							JOptionPane.ERROR_MESSAGE);
				}catch(java.lang.IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, "Radius cant be negative!","Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnPush = new GridBagConstraints();
		gbc_btnPush.fill = GridBagConstraints.BOTH;
		gbc_btnPush.insets = new Insets(0, 0, 5, 5);
		gbc_btnPush.gridx = 0;
		gbc_btnPush.gridy = 0;
		panel.add(btnPush, gbc_btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgPush dlgPush=new DlgPush();
				try {
				Circle N=dlm.getElementAt(0);
				dlgPush.txtX.setText(N.getCenter().getX()+ "");
				dlgPush.txtY.setText(N.getCenter().getY()+ "");
				dlgPush.txtRadius.setText(N.getRadius() + "");
				dlgPush.setVisible(true);
				
				if(dlgPush.isOK == true)
				{
					dlm.remove(0);
				}
				}catch(ArrayIndexOutOfBoundsException e1) 
				{
					JOptionPane.showMessageDialog(null, "List is empty!");
				}
			}
		});
		GridBagConstraints gbc_btnPop = new GridBagConstraints();
		gbc_btnPop.fill = GridBagConstraints.BOTH;
		gbc_btnPop.insets = new Insets(0, 0, 5, 5);
		gbc_btnPop.gridx = 1;
		gbc_btnPop.gridy = 0;
		panel.add(btnPop, gbc_btnPop);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 10;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList lstStack = new JList();
		scrollPane.setViewportView(lstStack);
		lstStack.setModel(dlm);
	}
}
