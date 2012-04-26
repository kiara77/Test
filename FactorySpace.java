import java.io.FileNotFoundException;

public class FactorySpace {
	private static final long serialVersionUID = 1L;
	
	boolean isNaive;
	public FactorySpace (boolean isNaive){
		this.isNaive=isNaive;
	}
	public Space getConfigurationSpace(int levelNumber) throws FileNotFoundException{
		Space space = null;
		if(isNaive){
			space = new NaiveSpace(levelNumber);
		}else{
			space = new OptiSpace();
		}
		return space;
	}
}
