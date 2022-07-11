package projekatzadatak2;

import java.awt.BorderLayout;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm=new DefaultListModel<Circle>();
	private ArrayList<Circle> list=new ArrayList<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
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
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlgSort=new DlgSort();
				try {
				dlgSort.setVisible(true);
				if(dlgSort.isOK==true) 
				{
					int r=Integer.parseInt(dlgSort.txtRadius.getText());
					if(r<0){throw new IllegalArgumentException();}
					int x=Integer.parseInt(dlgSort.txtX.getText());
					int y=Integer.parseInt(dlgSort.txtY.getText());
					Point p=new Point(x,y);
					Circle C=new Circle(p,r);
					dlm.addElement(C);
					list.add(C);
				}
				}catch(java.lang.NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "All valuse must be eneter and must be numbers!","Error",
							JOptionPane.ERROR_MESSAGE);
				}catch(java.lang.IllegalArgumentException e1)
				{
					JOptionPane.showMessageDialog(null, "Radius cant be negative!", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "List is empty!");
				}else {
				list.sort(null);
				list.sort(Collections.reverseOrder());
				dlm.clear();
				for(int i=0;i<list.size();i++) {
					dlm.addElement(list.get(i));
				}
				
			}
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 1;
		gbc_btnSort.gridy = 0;
		panel.add(btnSort, gbc_btnSort);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList lstSort = new JList();
		scrollPane.setViewportView(lstSort);
		lstSort.setModel(dlm);
	}

}
