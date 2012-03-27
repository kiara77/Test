import java.io.*;

public class Main{

	public static void main(String[] args) throws FileNotFoundException{
		BoolArray b = new BoolArray("boolean.txt");
		int sizeX = b.getSizeX();
		int sizeY = b.getSizeY();
		for(int i=0; i<sizeX; i++){
			for(int j=0; j<sizeY; j++){
				System.out.print((b.getCell(i,j))==true ? 1 : 0);
			}
			System.out.println();
		}
	}
}
