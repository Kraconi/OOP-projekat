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
import java.util.ArrayList;


public class PnlDrawing extends JPanel {
	
	public ArrayList<Shape> shapes=FrmDraw.dlm;
	static int j=FrmDraw.n;
	
	public PnlDrawing() {
	}
	
	public static void main(String[] args) 
	{
		PnlDrawing pnl=new PnlDrawing();
		pnl.setSize(700, 400);
		pnl.setVisible(true);
	}
}
