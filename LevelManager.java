import java.io.FileNotFoundException;


public class LevelManager {
	
	View view;
	LevelState levelState;
	public LevelManager() throws FileNotFoundException{
		levelState = new LevelState(1);
		view = new View(levelState.space.returnJPanel());
	}
	public void play(){
		view.construit();
	}
}