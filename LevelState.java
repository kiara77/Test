
public class LevelState {
	Space space;
	
	public Space spaceFromFile(int levelNumber){
		FactorySpace factory = new FactorySpace(true);
		Space a = factory.getConfigurationSpace();
		return a;
	}
}
