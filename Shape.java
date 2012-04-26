import java.io.FileNotFoundException;

import javax.swing.JPanel;


public class Shape {
	

	public Shape (){

	}
	
	public BoundingBox getBoundingBox(){
		BoundingBox b= new BoundingBox();
		return b;
	}
	
	public boolean collide(){
		return false;
	}

}
