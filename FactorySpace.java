import java.io.FileNotFoundException;

public class FactorySpace {
	private static final long serialVersionUID = 1L;
	
	boolean isNaive;
	
	public FactorySpace (boolean isNaive){
		this.isNaive=isNaive;
	}
	
	public Space getConfigurationSpace(int levelNumber) throws FileNotFoundException{
		if(isNaive){
			return new NaiveSpace(levelNumber);
		}else{
			return new OptiSpace();
		}
	}
}
