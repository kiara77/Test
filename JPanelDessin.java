import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class JPanelDessin extends JPanel {
	boolean [][] tab;
	final int UNITE =25;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanelDessin(boolean [][] tab){
		this.tab = tab;
		super.setSize(1200,1200);
		super.setPreferredSize(new Dimension(1200,1200));
		//super.setBackground(fondFenetre);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i=0;i<tab.length;i++){
			for(int j=0; j<tab[0].length;j++){
				if(tab[i][j]){
					g.setColor(Color.BLACK);
					g.fillRect(i*UNITE, j*UNITE, UNITE, UNITE);
				}
				g.setColor(Color.red);
				g.drawRect(i*UNITE, j*UNITE, UNITE, UNITE);
			}
		}		
	}
}
