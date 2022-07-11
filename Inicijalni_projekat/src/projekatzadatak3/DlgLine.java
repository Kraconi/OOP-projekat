package projekatzadatak3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtXStart;
	protected JTextField txtYStart;
	protected JTextField txtXEnd;
	protected JTextField txtYEnd;
	protected boolean isOK;
	public Line line;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{276, 0};
		gbl_contentPanel.rowHeights = new int[]{106, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel pnlStart = new JPanel();
			GridBagConstraints gbc_pnlStart = new GridBagConstraints();
			gbc_pnlStart.insets = new Insets(0, 0, 5, 0);
			gbc_pnlStart.fill = GridBagConstraints.BOTH;
			gbc_pnlStart.gridx = 0;
			gbc_pnlStart.gridy = 0;
			contentPanel.add(pnlStart, gbc_pnlStart);
			GridBagLayout gbl_pnlStart = new GridBagLayout();
			gbl_pnlStart.columnWidths = new int[]{0, 0, 0};
			gbl_pnlStart.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_pnlStart.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlStart.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlStart.setLayout(gbl_pnlStart);
			{
				JLabel lblStaringPoint = new JLabel("Staring point");
				lblStaringPoint.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblStaringPoint = new GridBagConstraints();
				gbc_lblStaringPoint.insets = new Insets(0, 0, 5, 5);
				gbc_lblStaringPoint.gridx = 0;
				gbc_lblStaringPoint.gridy = 0;
				pnlStart.add(lblStaringPoint, gbc_lblStaringPoint);
			}
			{
				JLabel lblXStart = new JLabel("X coordinate:");
				GridBagConstraints gbc_lblXStart = new GridBagConstraints();
				gbc_lblXStart.anchor = GridBagConstraints.EAST;
				gbc_lblXStart.insets = new Insets(0, 0, 5, 5);
				gbc_lblXStart.gridx = 0;
				gbc_lblXStart.gridy = 1;
				pnlStart.add(lblXStart, gbc_lblXStart);
			}
			{
				txtXStart = new JTextField();
				GridBagConstraints gbc_txtXStart = new GridBagConstraints();
				gbc_txtXStart.insets = new Insets(0, 0, 5, 0);
				gbc_txtXStart.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXStart.gridx = 1;
				gbc_txtXStart.gridy = 1;
				pnlStart.add(txtXStart, gbc_txtXStart);
				txtXStart.setColumns(10);
			}
			{
				JLabel lblYStart = new JLabel("Y coordinate:");
				GridBagConstraints gbc_lblYStart = new GridBagConstraints();
				gbc_lblYStart.anchor = GridBagConstraints.EAST;
				gbc_lblYStart.insets = new Insets(0, 0, 0, 5);
				gbc_lblYStart.gridx = 0;
				gbc_lblYStart.gridy = 3;
				pnlStart.add(lblYStart, gbc_lblYStart);
			}
			{
				txtYStart = new JTextField();
				GridBagConstraints gbc_txtYStart = new GridBagConstraints();
				gbc_txtYStart.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYStart.gridx = 1;
				gbc_txtYStart.gridy = 3;
				pnlStart.add(txtYStart, gbc_txtYStart);
				txtYStart.setColumns(10);
			}
		}
		{
			JPanel pnlEnd = new JPanel();
			GridBagConstraints gbc_pnlEnd = new GridBagConstraints();
			gbc_pnlEnd.fill = GridBagConstraints.BOTH;
			gbc_pnlEnd.gridx = 0;
			gbc_pnlEnd.gridy = 1;
			contentPanel.add(pnlEnd, gbc_pnlEnd);
			GridBagLayout gbl_pnlEnd = new GridBagLayout();
			gbl_pnlEnd.columnWidths = new int[]{82, 0, 0};
			gbl_pnlEnd.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_pnlEnd.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlEnd.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlEnd.setLayout(gbl_pnlEnd);
			{
				JLabel lblEndPoint = new JLabel("End point");
				lblEndPoint.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
				gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
				gbc_lblEndPoint.gridx = 0;
				gbc_lblEndPoint.gridy = 0;
				pnlEnd.add(lblEndPoint, gbc_lblEndPoint);
			}
			{
				JLabel lblXEnd = new JLabel("X coordinate:");
				GridBagConstraints gbc_lblXEnd = new GridBagConstraints();
				gbc_lblXEnd.anchor = GridBagConstraints.EAST;
				gbc_lblXEnd.insets = new Insets(0, 0, 5, 5);
				gbc_lblXEnd.gridx = 0;
				gbc_lblXEnd.gridy = 1;
				pnlEnd.add(lblXEnd, gbc_lblXEnd);
			}
			{
				txtXEnd = new JTextField();
				GridBagConstraints gbc_txtXEnd = new GridBagConstraints();
				gbc_txtXEnd.insets = new Insets(0, 0, 5, 0);
				gbc_txtXEnd.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXEnd.gridx = 1;
				gbc_txtXEnd.gridy = 1;
				pnlEnd.add(txtXEnd, gbc_txtXEnd);
				txtXEnd.setColumns(10);
			}
			{
				JLabel lblYEnd = new JLabel("Y coordinate:");
				GridBagConstraints gbc_lblYEnd = new GridBagConstraints();
				gbc_lblYEnd.anchor = GridBagConstraints.EAST;
				gbc_lblYEnd.insets = new Insets(0, 0, 0, 5);
				gbc_lblYEnd.gridx = 0;
				gbc_lblYEnd.gridy = 3;
				pnlEnd.add(lblYEnd, gbc_lblYEnd);
			}
			{
				txtYEnd = new JTextField();
				GridBagConstraints gbc_txtYEnd = new GridBagConstraints();
				gbc_txtYEnd.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYEnd.gridx = 1;
				gbc_txtYEnd.gridy = 3;
				pnlEnd.add(txtYEnd, gbc_txtYEnd);
				txtYEnd.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnColor = new JButton("Color");
				buttonPane.add(btnColor);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
						int x1=Integer.parseInt(txtXStart.getText());
						int x2=Integer.parseInt(txtXEnd.getText());
						int y1=Integer.parseInt(txtYStart.getText());
						int y2=Integer.parseInt(txtYEnd.getText());
						if(((txtXStart.getText().trim().isEmpty()))||((txtYStart.getText().trim().isEmpty()))||
								((txtXEnd.getText().trim().isEmpty()))||((txtYEnd.getText().trim().isEmpty()))) 
						{
							JOptionPane.showMessageDialog(null, "All fields are required!", "Error",JOptionPane.ERROR_MESSAGE);
						}else if((x1<0)||(x2<0)||(y1<0)||(y2<0)) 
						{
							JOptionPane.showMessageDialog(null, "All values must be positive!", "Error",JOptionPane.ERROR_MESSAGE);
						}else 
						{
							line=new Line((new Point(x1,y1)),(new Point(x2,y2)),false);
							isOK=true;
							setVisible(false);
						}
						}catch(Exception e1) 
						{
							JOptionPane.showMessageDialog(null, "All values must be numbers!", "Error",JOptionPane.ERROR_MESSAGE);
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
	public Line getLine() {
		return line;
	}
	public void setLine(Line line) {
		this.line = line;
	}
}
