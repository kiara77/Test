import java.io.FileNotFoundException;

import javax.swing.JPanel;


public class NaiveSpace extends Space{
	public NaiveSpace(int levelNumber) throws FileNotFoundException{
		super();
		obstacles = new ObstacleTable("level-"+levelNumber+".txt");
	}

	@Override	
	public JPanelDraw returnJPanel() {
		return new JPanelDraw(this);
	}

	@Override
	public boolean collide() {
	//formule     :   (x-a)² + (y-b)² = rayon²   centre(a,b)
		int i_init =ball.x-(ball.radius*UNITE);
		int j_init =ball.y-(ball.radius*UNITE);
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;
		
		int i_final =ball.x+(ball.radius*UNITE);
		int j_final =ball.y+(ball.radius*UNITE);
		if(i_final>longueur*UNITE) i_final=longueur*UNITE;
		if(j_final>largeur*UNITE) j_final=largeur*UNITE;

		
		for(int i=i_init ; i<i_final ; i++){
			for(int j=j_init ; j<j_final ; j++){
//				System.out.println("i:"+i+" j:"+j+" ball.x:"+ball.x+" ball.y:"+ball.y);
				if(((i-ball.x)*(i-ball.x)+(j-ball.y)*(j-ball.y))== ball.radius *ball.radius){
					System.out.println("i2:"+i/UNITE+" j2:"+j/UNITE);
//					obstacles.printObstacle();
					if(obstacles.isObstacle(i/UNITE,j/UNITE)){
						System.out.println("iciiiiiiiiii");
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
		int i_init =ball.x-ball.radius;
		int j_init =ball.y-ball.radius;
		if(i_init<0) i_init=0;
		if(j_init<0) j_init=0;
		
		for(int i=i_init;i<ball.x+ball.radius*2;i++){
			for(int j=j_init;j<ball.y+ball.radius*2;j++){
				if(((i-ball.x)*(i-ball.x)+(j-ball.y)*(j-ball.y))== ball.radius *ball.radius)
					if(obstacles.isObstacle(i/UNITE, j/UNITE))
						return new Point(i,j);
			}
		}
		return new Point(-1,-1);
	}
	
	
}
