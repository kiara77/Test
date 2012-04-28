import javax.swing.JPanel;


public interface Obstacles {
	
	public void setObstacles(int x, int y);
	
	public boolean isObstacle(int x, int y);
	
	public void printObstacle();
}
