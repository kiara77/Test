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
	public static void main(String[]args){
		boolean [][] tabtemp = new boolean [15][8];
		for(int i=0;i<tabtemp.length;i++){
			for(int j=0; j<tabtemp[0].length;j++){
				tabtemp[i][j]=false;
			}
		}
		tabtemp[10][3]=true;
		tabtemp[10][4]=true;
		tabtemp[9][3]=true;
		tabtemp[9][2]=true;
		tabtemp[0][0]=true;
		FenetreDessin fd = new FenetreDessin(tabtemp);
		fd.construit();
	}
}
