import java.io.FileNotFoundException;


public class Game {
	LevelManager levelManager;
	
	public Game() throws FileNotFoundException{
		levelManager = new LevelManager();
	}
	public void retriveInfoLevels(){
		
	}
	public boolean existNextLevel(){
		return false;
	}
	public void actionsGameFinish(){
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Game g = new Game();
		g.levelManager.play();
	}
}
