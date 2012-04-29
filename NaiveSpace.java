import java.io.FileNotFoundException;

import javax.swing.JPanel;


public class NaiveSpace extends Space{
	public NaiveSpace(int levelNumber) throws FileNotFoundException{
		super();
		FactoryObstacles factObstacles = new FactoryObstacles(true);// write false to use FactoryVector
		obstacles = factObstacles.getConfigurationObstacle(levelNumber);
	}

	@Override	
	public JPanelDraw returnJPanel() {
		return new JPanelDraw(this);
	}

	@Override
	public boolean collide() {
		//formule     :   (x-a)² + (y-b)² = rayon²   centre(a,b)
		int i_init = ball.x-ball.radius;
		int j_init = ball.y-ball.radius;
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;

		int i_final = ball.x+ball.radius;
		int j_final = ball.y+ball.radius;
		if(i_final>longueur) i_final=longueur;
		if(j_final>largeur) j_final=largeur;

		for(int i=i_init ; i<i_final ; i++){
			for(int j=j_init ; j<j_final ; j++){
				//				System.out.println("i:"+i+" j:"+j+" ball.x:"+ball.x+" ball.y:"+ball.y);
				if(((i-ball.x)*(i-ball.x)+(j-ball.y)*(j-ball.y)) == ball.radius*ball.radius){
					//					System.out.println("i2:"+i/UNITE+" j2:"+j/UNITE);
					//					obstacles.printObstacle();
					if(obstacles.isObstacle(i, j)){
						System.out.println("TOUCHE");
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Point collidePoint() {
		//Use it , after collide() ->true
		int i_init = ball.x-ball.radius;
		int j_init = ball.y-ball.radius;
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;

		for(int i=i_init; i<ball.x+ball.radius; i++){
			for(int j=j_init; j<ball.y+ball.radius; j++){
				if(((i-ball.x)*(i-ball.x)+(j-ball.y)*(j-ball.y)) == ball.radius *ball.radius)
					if(obstacles.isObstacle(i, j))
						return new Point(i, j);
			}
		}
		return new Point(-1, -1);
	}
}
