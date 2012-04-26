public class FactorySpace {
	private static final long serialVersionUID = 1L;
	
	boolean isNaive;
	public FactorySpace (boolean isNaive){
		this.isNaive=isNaive;
	}
	public Space getConfigurationSpace(){
		Space space = null;
		if(isNaive){
			space = new NaiveSpace();
		}else{
			space = new OptiSpace();
		}
		return space;
	}
}
