import java.io.FileNotFoundException;


public class Game {
	LevelManager levelManager;
	int nbLevel;
	int numLevel;
	
	public Game() throws FileNotFoundException{
		numLevel=2;
		nbLevel=10;
		levelManager = new LevelManager(numLevel);
	}
	
	public void retriveInfoLevels(){
		
	}
	public boolean existNextLevel(){
		return false;
	}
	public void actionsGameFinish(){
		
	}
	public void play() throws FileNotFoundException{
		while(numLevel<nbLevel){
			levelManager.playLevel();
			levelManager = new LevelManager(++numLevel);
		}	
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Game g = new Game();
		g.play();
	}
}
