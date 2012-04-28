import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel implements MouseListener, MouseMotionListener {
	Space space;
	final int UNITE =5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanelDraw(){
		
	}
	public JPanelDraw(Space space){
		this.space=space;
		super.setSize(1200,1200);
		super.setPreferredSize(new Dimension(1200,1200));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//super.setBackground(fondFenetre);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.orange);
		g.drawOval((space.ball.x-space.ball.radius)*UNITE,(space.ball.y-space.ball.radius)*UNITE,space.ball.radius*2*UNITE,space.ball.radius*2*UNITE);
		g.fillOval((space.ball.x-space.ball.radius)*UNITE,(space.ball.y-space.ball.radius)*UNITE,space.ball.radius*2*UNITE,space.ball.radius*2*UNITE);
		//TODO vecteur vitesse, a supprimer
		g.setColor(Color.green);
		g.drawLine(space.ball.x*UNITE, space.ball.y*UNITE, (space.ball.x+space.ball.dirX)*UNITE, (space.ball.y+space.ball.dirY)*UNITE);
		//TODO end
		for(int i=0; i<space.longueur;i++){
			for(int j=0;j<space.largeur;j++){
				if(space.obstacles.isObstacle(i,j)){
					g.setColor(Color.BLACK);
					g.fillRect(i*UNITE, j*UNITE, UNITE, UNITE);
				}
				g.setColor(Color.red);
				g.drawRect(i*UNITE, j*UNITE, UNITE, UNITE);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		space.obstacles.setObstacles(arg0.getX()/UNITE,arg0.getY()/UNITE);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
