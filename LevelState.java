import java.io.FileNotFoundException;


public class LevelState {
	Space space;
	
	public LevelState(int numLevel) throws FileNotFoundException{
		space = spaceFromFile(numLevel);
	}
	public Space spaceFromFile(int numLevel) throws FileNotFoundException{
		FactorySpace factory = new FactorySpace(true);
		return factory.getConfigurationSpace(numLevel);
	}
	
	public boolean isFinish(){
		return ((space.winPoint.getX()<=space.ball.getX()+space.ball.getRadius()) &&
				(space.winPoint.getX()>=space.ball.getX()-space.ball.getRadius()) &&
				(space.winPoint.getY()<=space.ball.getY()+space.ball.getRadius()) &&
				(space.winPoint.getY()>=space.ball.getY()-space.ball.getRadius()) &&
				(distance2point(space.winPoint,space.ball.getX(),space.ball.getY())<=space.ball.getRadius()));
	}
	
	public double distance2point(Point win,int x, int y){
		return Math.sqrt(Math.pow(x-win.getX(),2)+Math.pow(y-win.getY(),2));
	}
}
