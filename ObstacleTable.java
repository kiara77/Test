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
		//Position pixel Gagnant
		Integer.parseInt(scan.nextLine());
		Integer.parseInt(scan.nextLine());
		//
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
	@Override
	public Point collisionNewDirBall(Ball ball, Point pointCollide){
		System.out.println("Point Collide : "+pointCollide.getX()+" "+pointCollide.getY());
		//Cas 1
		if ((ball.isDir(1,0)||ball.isDir(1,1)||ball.isDir(1,-1)) &&
		 (pointCollide.getX()>ball.getX())&&(pointCollide.getY()==ball.getY()))
				return new Point(-1,0);
		if ((ball.isDir(-1,1)||ball.isDir(-1,0)||ball.isDir(-1,-1)) &&
			(pointCollide.getX()<ball.getX())&&(pointCollide.getY()==ball.getY()))
				return new Point(1,0);
		//Cas 2
		if ((ball.isDir(1,1)||ball.isDir(0,1)||ball.isDir(-1,1)) &&
			(pointCollide.getX()==ball.getX())&&(pointCollide.getY()>ball.getY()))
				return new Point(0,-1);
		if ((ball.isDir(1,-1)||ball.isDir(0,-1)||ball.isDir(-1,-1)) &&
			(pointCollide.getX()==ball.getX())&&(pointCollide.getY()<ball.getY()))
				return new Point(0,1);		
		//Cas 3
		if ((ball.isDir(1,0)||ball.isDir(1,1)||ball.isDir(0,1)) &&
		 (pointCollide.getX()>ball.getX())&&(pointCollide.getY()>ball.getY()))
				return new Point(-1,-1);
		if ((ball.isDir(-1,1)||ball.isDir(-1,0)||ball.isDir(0,-1)) &&
			(pointCollide.getX()<ball.getX())&&(pointCollide.getY()<ball.getY()))
				return new Point(1,1);
		//Cas 4
		if ((ball.isDir(-1,1)||ball.isDir(0,1)||ball.isDir(-1,0)) &&
			(pointCollide.getX()<ball.getX())&&(pointCollide.getY()>ball.getY()))
				return new Point(1,-1);
		if ((ball.isDir(1,-1)||ball.isDir(0,-1)||ball.isDir(1,0)) &&
			(pointCollide.getX()>ball.getX())&&(pointCollide.getY()<ball.getY()))
				return new Point(-1,1);				

		System.out.println("probleme new direction Ball");
		return new Point(-1,-1);
	}
}
