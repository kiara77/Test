import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


import javax.swing.JPanel;


public class JPanelDrawNaive extends JPanelDraw implements MouseListener, MouseMotionListener {
	NaiveSpace space;
	final int UNITE =25;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanelDrawNaive(NaiveSpace space){
		this.space =space;
		super.setSize(1200,1200);
		super.setPreferredSize(new Dimension(1200,1200));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//super.setBackground(fondFenetre);
	}
	
	public void paintComponent(Graphics g){
	//	super.paintComponent(g);
		for (int i=0;i<space.obstacles.getGrid().length;i++){
			for(int j=0; j<space.obstacles.getGrid()[0].length;j++){
				if(space.obstacles.getGrid()[i][j]){
					g.setColor(Color.BLACK);
					g.fillRect(i*UNITE, j*UNITE, UNITE, UNITE);
				}
				g.setColor(Color.red);
				g.drawRect(i*UNITE, j*UNITE, UNITE, UNITE);
			}
		}
		g.setColor(Color.orange);
		g.drawOval(space.ball.x,space.ball.y,space.ball.radius*UNITE,space.ball.radius*UNITE);
		g.fillOval(space.ball.x,space.ball.y,space.ball.radius*UNITE,space.ball.radius*UNITE);
	}
	
	public boolean[][] returnSetObstacle(){
		return space.obstacles.getGrid();
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
		space.obstacles.getGrid()[arg0.getX()/UNITE][arg0.getY()/UNITE]=true;
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
