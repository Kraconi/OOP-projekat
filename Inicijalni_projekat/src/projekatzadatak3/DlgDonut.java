package projekatzadatak3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtX;
	protected JTextField txtY;
	private JTextField txtRadius;
	private JTextField txtInner;
	protected boolean isOK;
	public Donut donut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblX = new JLabel("X coordinate:");
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.anchor = GridBagConstraints.EAST;
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.gridx = 0;
				gbc_lblX.gridy = 0;
				panel.add(lblX, gbc_lblX);
			}
			{
				txtX = new JTextField();
				GridBagConstraints gbc_txtX = new GridBagConstraints();
				gbc_txtX.insets = new Insets(0, 0, 5, 0);
				gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtX.gridx = 1;
				gbc_txtX.gridy = 0;
				panel.add(txtX, gbc_txtX);
				txtX.setColumns(10);
			}
			{
				JLabel lblY = new JLabel("Y coordinate:");
				GridBagConstraints gbc_lblY = new GridBagConstraints();
				gbc_lblY.anchor = GridBagConstraints.EAST;
				gbc_lblY.insets = new Insets(0, 0, 5, 5);
				gbc_lblY.gridx = 0;
				gbc_lblY.gridy = 2;
				panel.add(lblY, gbc_lblY);
			}
			{
				txtY = new JTextField();
				GridBagConstraints gbc_txtY = new GridBagConstraints();
				gbc_txtY.insets = new Insets(0, 0, 5, 0);
				gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtY.gridx = 1;
				gbc_txtY.gridy = 2;
				panel.add(txtY, gbc_txtY);
				txtY.setColumns(10);
			}
			{
				JLabel lblRadius = new JLabel("Radius:");
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.anchor = GridBagConstraints.EAST;
				gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadius.gridx = 0;
				gbc_lblRadius.gridy = 4;
				panel.add(lblRadius, gbc_lblRadius);
			}
			{
				txtRadius = new JTextField();
				GridBagConstraints gbc_txtRadius = new GridBagConstraints();
				gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRadius.gridx = 1;
				gbc_txtRadius.gridy = 4;
				panel.add(txtRadius, gbc_txtRadius);
				txtRadius.setColumns(10);
			}
			{
				JLabel lblInner = new JLabel("Inner radius:");
				GridBagConstraints gbc_lblInner = new GridBagConstraints();
				gbc_lblInner.anchor = GridBagConstraints.EAST;
				gbc_lblInner.insets = new Insets(0, 0, 0, 5);
				gbc_lblInner.gridx = 0;
				gbc_lblInner.gridy = 6;
				panel.add(lblInner, gbc_lblInner);
			}
			{
				txtInner = new JTextField();
				GridBagConstraints gbc_txtInner = new GridBagConstraints();
				gbc_txtInner.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInner.gridx = 1;
				gbc_txtInner.gridy = 6;
				panel.add(txtInner, gbc_txtInner);
				txtInner.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JButton btnInnerColor = new JButton("Inner color");
				GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
				gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
				gbc_btnInnerColor.gridx = 0;
				gbc_btnInnerColor.gridy = 0;
				panel.add(btnInnerColor, gbc_btnInnerColor);
			}
			{
				JButton btnOutlineColor = new JButton("Outline color");
				GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
				gbc_btnOutlineColor.gridx = 1;
				gbc_btnOutlineColor.gridy = 0;
				panel.add(btnOutlineColor, gbc_btnOutlineColor);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						int x=Integer.parseInt(txtX.getText());
						int y=Integer.parseInt(txtY.getText());
						int radius=Integer.parseInt(txtRadius.getText());
						int iradius=Integer.parseInt(txtInner.getText());
						if((txtX.getText().trim().isEmpty())||(txtY.getText().trim().isEmpty())
								||(txtRadius.getText().trim().isEmpty())||(txtInner.getText().trim().isEmpty())) 
						{
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",JOptionPane.ERROR_MESSAGE);
						}else if((x<0)||(y<0)||(radius<=0)||(iradius<=0)) 
						{
							JOptionPane.showMessageDialog(null, "All values must be positive!", "ERROR",JOptionPane.ERROR_MESSAGE);
						}else if(iradius>radius)
						{
							JOptionPane.showMessageDialog(null, "Inner radius must be smaller than outer radius!", "ERROR",JOptionPane.ERROR_MESSAGE);
						}else
						{
							donut=new Donut(new Point(x,y),radius,iradius,false);
							isOK=true;
							setVisible(false);
						}
						}catch(Exception e1) 
						{
							JOptionPane.showMessageDialog(null, "All values must be numbers!", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
