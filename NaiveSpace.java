import java.io.FileNotFoundException;

import javax.swing.JPanel;


public class NaiveSpace extends Space{
	public NaiveSpace(int levelNumber) throws FileNotFoundException{
		super(levelNumber);
		
		FactoryObstacles factObstacles = new FactoryObstacles(true);// write false to use FactoryVector
		obstacles = factObstacles.getConfigurationObstacle(levelNumber);
	}

	@Override	
	public JPanelDraw returnJPanel() {
		return new JPanelDraw(this);
	}

	@Override
	public boolean collide() {
		int i_init = ball.getX()-ball.getRadius();
		int j_init = ball.getY()-ball.getRadius();
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;

		int i_final = ball.getX()+ball.getRadius();
		int j_final = ball.getY()+ball.getRadius();
		if(i_final>longueur) i_final=longueur;
		if(j_final>largeur) j_final=largeur;

		for(int i=i_init ; i<=i_final ; i++){
			for(int j=j_init ; j<=j_final ; j++){
				if(distance2point(ball.getX(),ball.getY(),i,j)<=ball.getRadius()
					&& obstacles.isObstacle(i, j)){
						System.out.println("TOUCHE");
						return true;
				}
			}
		}
		return false;
	}
	

	
	@Override
	public Point collidePoint() {
		//Use it , after collide() ->true
		int i_init = ball.getX()-ball.getRadius();
		int j_init = ball.getY()-ball.getRadius();
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;

		int i_final = ball.getX()+ball.getRadius();
		int j_final = ball.getY()+ball.getRadius();
		if(i_final>longueur) i_final=longueur;
		if(j_final>largeur) j_final=largeur;

		for(int i=i_init ; i<=i_final ; i++){
			for(int j=j_init ; j<=j_final ; j++){
				if(distance2point(ball.getX(),ball.getY(),i,j)<=ball.getRadius()
					&& obstacles.isObstacle(i, j)){
						return new Point (i,j);
				}
			}
		}
		return new Point (-1,-1);
	}
}
