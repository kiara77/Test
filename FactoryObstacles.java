import java.io.FileNotFoundException;


public class FactoryObstacles {
	private static final long serialVersionUID = 1L;
	
	boolean isObstacleTable;
	public FactoryObstacles (boolean isObstacleTable){
		this.isObstacleTable=isObstacleTable;
	}
	public Obstacles getConfigurationObstacle(int levelNumber) throws FileNotFoundException{
		if(isObstacleTable){
			return new ObstacleTable("level-"+levelNumber+".txt");
		}else{
			return new ObstacleVector();
		}
	}
}

