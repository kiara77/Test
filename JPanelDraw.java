import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel implements MouseListener, MouseMotionListener {
	Space space;
	final int UNITE =25;
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
		g.drawOval(space.ball.x,space.ball.y,space.ball.radius*UNITE,space.ball.radius*UNITE);
		g.fillOval(space.ball.x,space.ball.y,space.ball.radius*UNITE,space.ball.radius*UNITE);
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
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
