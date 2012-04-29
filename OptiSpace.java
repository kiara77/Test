import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JPanel;


public class OptiSpace extends Space{

	ObstacleVector obstacles;
	public OptiSpace(int levelNumber) throws FileNotFoundException{
		super(levelNumber);
	}

	@Override
	public JPanelDraw returnJPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean collide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point collidePoint() {
		// TODO Auto-generated method stub
		return null;
	}
}
