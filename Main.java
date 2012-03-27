import java.io.*;

public class Main{

	public static void main(String[] args) throws FileNotFoundException{
		BoolArray b = new BoolArray("boolean.txt");
		FenetreDessin fd = new FenetreDessin(b.getGrid());
		fd.construit();
	}
}
