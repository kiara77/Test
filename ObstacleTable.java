import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;


public class ObstacleTable implements Obstacles{

	private boolean grid[][];


	public ObstacleTable(String filename) throws FileNotFoundException{
		FileInputStream file = new FileInputStream(filename); 
		Scanner scan = new Scanner(file);
		String temp;
		int sizeX = Integer.parseInt(scan.nextLine());
		int sizeY = Integer.parseInt(scan.nextLine());
		grid = new boolean[sizeX][sizeY];
		int i=0;
		while(scan.hasNextLine()){
			temp = scan.nextLine();
			for(int j=0; j<temp.length(); j++){
				grid[i][j] = (Integer.parseInt(temp.substring(j, j+1)))==1 ? true : false;
			}
			i++;
		}
	}
	
	public boolean[][] getGrid(){
		return grid;
	}
	public boolean getCell(int i, int j){
		return grid[i][j];
	}
	@Override
	public void setObstacles() {
		// TODO Auto-generated method stub
		
	}
}
