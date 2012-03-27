import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;


public class FenetreDessin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected GraphicsEnvironment graphicsEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();//get local graphics environment	
	protected Rectangle maxWindowBounds=graphicsEnv.getMaximumWindowBounds();//get maximum window bounds
	protected int hauteur = (int)maxWindowBounds.getHeight();
	protected int largeur = (int)maxWindowBounds.getWidth();
	JPanelDessin panel;
	boolean [][] obstaclesTab;

	public FenetreDessin(boolean [][] tab){
		obstaclesTab = tab;
		super.setTitle("Projet Long");
		super.setSize(largeur,hauteur);
		super.setResizable(true);
		super.setBackground(Color.WHITE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void construit(){
		panel = new JPanelDessin(obstaclesTab);
		super.setContentPane(panel);
		super.setVisible(true);
	}
}
