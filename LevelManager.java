import java.io.FileNotFoundException;


public class LevelManager {
	
	View view;
	BoolArray boolArray;
	
	public LevelManager() throws FileNotFoundException{
		boolArray = new BoolArray("boolean.txt");
		view = new View(boolArray.getGrid());
	}
	public void play(){
		view.construit();
	}
}
