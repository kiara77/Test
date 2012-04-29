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
		g.setColor(Color.blue);
		g.drawOval((space.ball.getX()-space.ball.getRadius())*UNITE,(space.ball.getY()-space.ball.getRadius())*UNITE,space.ball.getRadius()*2*UNITE,space.ball.getRadius()*2*UNITE);
		g.setColor(Color.orange);
		g.fillOval((space.ball.getX()-space.ball.getRadius())*UNITE,(space.ball.getY()-space.ball.getRadius())*UNITE,space.ball.getRadius()*2*UNITE,space.ball.getRadius()*2*UNITE);
		//TODO vecteur vitesse, a supprimer
		g.setColor(Color.green);
		g.drawLine(space.ball.getX()*UNITE, space.ball.getY()*UNITE, (space.ball.getX()+space.ball.getDirX())*UNITE, (space.ball.getY()+space.ball.getDirY())*UNITE);
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
		g.setColor(Color.CYAN);
		g.fillRect(space.winPoint.getX()*UNITE,space.winPoint.getY()*UNITE, UNITE, UNITE);
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
		
		if(arg0.getX()/UNITE<=space.longueur && arg0.getY()/UNITE<=space.largeur
		&& (space.distance2point(space.ball.getX(),space.ball.getY(),arg0.getX()/UNITE,arg0.getY()/UNITE)>space.ball.getRadius())){
			space.obstacles.setObstacles(arg0.getX()/UNITE,arg0.getY()/UNITE);
		}
		
		if(arg0.getX()/UNITE<=space.longueur && (arg0.getY()+UNITE)/UNITE<=space.largeur
		&& (space.distance2point(space.ball.getX(),space.ball.getY(),arg0.getX()/UNITE,arg0.getY()/UNITE)>space.ball.getRadius())){
			space.obstacles.setObstacles(arg0.getX()/UNITE,(arg0.getY()+UNITE)/UNITE);
		}
		
		if((arg0.getX()+UNITE)/UNITE<=space.longueur && arg0.getY()/UNITE<=space.largeur
		&& (space.distance2point(space.ball.getX(),space.ball.getY(),arg0.getX()/UNITE,arg0.getY()/UNITE)>space.ball.getRadius())){
			space.obstacles.setObstacles((arg0.getX()+UNITE)/UNITE,arg0.getY()/UNITE);
		}
		
		if((arg0.getX()+UNITE)/UNITE<=space.longueur && (arg0.getY()+UNITE)/UNITE<=space.largeur
		&& (space.distance2point(space.ball.getX(),space.ball.getY(),arg0.getX()/UNITE,arg0.getY()/UNITE)>space.ball.getRadius())){
			space.obstacles.setObstacles((arg0.getX()+UNITE)/UNITE,(arg0.getY()+UNITE)/UNITE);
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
