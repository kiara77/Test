import java.io.*;
import java.util.*;

public class BoolArray{

	private boolean grid[][];
	private int sizeX, sizeY;

	public BoolArray(String filename) throws FileNotFoundException{
		FileInputStream file = new FileInputStream(filename); 
		Scanner scan = new Scanner(file);
		String temp;
		sizeX = Integer.parseInt(scan.nextLine());
		sizeY = Integer.parseInt(scan.nextLine());
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

	public int getSizeX(){
		return sizeX;
	}

	public int getSizeY(){
		return sizeY;
	}
}
