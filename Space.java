import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JPanel;


public abstract class Space {
	
	Shape shape;
	Ball ball;
	
	Space(){
		ball = new Ball();
		shape=new Shape();
	}
	public abstract JPanelDraw returnJPanel();
}
