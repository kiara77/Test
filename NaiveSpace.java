import java.io.FileNotFoundException;

import javax.swing.JPanel;


public class NaiveSpace extends Space{
	
	ObstacleTable obstacles;
	
	public NaiveSpace(int levelNumber) throws FileNotFoundException{
		super();
		obstacles = new ObstacleTable("level-"+levelNumber+".txt");
	}

	@Override	
	public JPanelDraw returnJPanel() {
		return new JPanelDrawNaive(this);
	}
}
