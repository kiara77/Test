import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected GraphicsEnvironment graphicsEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();//get local graphics environment	
	protected Rectangle maxWindowBounds=graphicsEnv.getMaximumWindowBounds();//get maximum window bounds
	protected int hauteur = (int)maxWindowBounds.getHeight();
	protected int largeur = (int)maxWindowBounds.getWidth();
	JPanel jp;

	public View(JPanel jp){
		this.jp=jp;
		super.setTitle("Projet Long");
		super.setSize(largeur,hauteur);
		super.setResizable(true);
		super.setBackground(Color.WHITE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void construit(){
		super.setContentPane(jp);
		super.setVisible(true);
	}
}
