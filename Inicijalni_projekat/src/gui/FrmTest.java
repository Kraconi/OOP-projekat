package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup=new ButtonGroup();
	private DefaultListModel<String> dlm=new DefaultListModel();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlsouth = new JPanel();
		contentPane.add(pnlsouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlsouth = new GridBagLayout();
		gbl_pnlsouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlsouth.rowHeights = new int[]{0, 0};
		gbl_pnlsouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlsouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlsouth.setLayout(gbl_pnlsouth);
		
		JButton btnIspis = new JButton("Klikni me");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Antistres dugme","Poruka",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnIspis = new GridBagConstraints();
		gbc_btnIspis.gridx = 6;
		gbc_btnIspis.gridy = 0;
		pnlsouth.add(btnIspis, gbc_btnIspis);
		
		JPanel pnlcenter = new JPanel();
		contentPane.add(pnlcenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlcenter = new GridBagLayout();
		gbl_pnlcenter.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlcenter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlcenter.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlcenter.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlcenter.setLayout(gbl_pnlcenter);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dlm.addElement(lblCrvena.getText());
				lblCrvena.setForeground(Color.RED);
				lblPlava.setForeground(Color.BLACK);
				lblZuta.setForeground(Color.BLACK);
			}
		});
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 1;
		pnlcenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		btnGroup.add(tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 1;
		pnlcenter.add(lblCrvena, gbc_lblCrvena);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		pnlcenter.add(scrollPane, gbc_scrollPane);
		
		JList lstBoje = new JList();
		scrollPane.setViewportView(lstBoje);
		lstBoje.setModel(dlm);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlm.addElement(lblPlava.getText());
				lblCrvena.setForeground(Color.BLACK);
				lblPlava.setForeground(Color.BLUE);
				lblZuta.setForeground(Color.BLACK);
			}
		});
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 2;
		pnlcenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		btnGroup.add(tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 2;
		pnlcenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		tglbtnZuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlm.addElement(lblZuta.getText());
				lblCrvena.setForeground(Color.BLACK);
				lblPlava.setForeground(Color.BLACK);
				lblZuta.setForeground(Color.YELLOW);
			}
		});
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 3;
		pnlcenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		btnGroup.add(tglbtnZuta);
		
		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 0, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 3;
		pnlcenter.add(lblZuta, gbc_lblZuta);
		
		JPanel pnlnorth = new JPanel();
		pnlnorth.setBackground(Color.GREEN);
		contentPane.add(pnlnorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		pnlnorth.add(lblNaslov);
	}

}
