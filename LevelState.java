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
}
