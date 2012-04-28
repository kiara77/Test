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
		int j=0;
		while(scan.hasNextLine()){
			temp = scan.nextLine();
			for(int i=0; i<temp.length(); i++){
				grid[i][j] = (Integer.parseInt(temp.substring(i, i+1)))==1 ? true : false;
			}
			j++;
		}
	}
/*	Ne doit normalement plus etre utilise
	public boolean[][] getGrid(){
		return grid;
	}
*/
	public boolean getCell(int i, int j){
		return grid[i][j];
	}
	@Override
	public void setObstacles(int x, int y) {
		grid[x][y]=true;
		
	}

	@Override
	public boolean isObstacle(int x, int y) {
		return grid[x][y];
	}
	@Override
	public void printObstacle(){
		for(int i=0; i<grid.length;i++){
			for(int j=0; j<grid[0].length;j++){
				if(grid[i][j]){
					System.out.print("i:"+i+" j:"+j+"    ");
				}
			}
		}
		System.out.println();
	}
}
