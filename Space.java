public abstract class Space {
	int longueur;
	int largeur;
	final int UNITE = 25;
	Obstacles obstacles;
//	Vector <Shape> shape;
	Ball ball;
	
	Space(){
		ball = new Ball();
		longueur=47;
		largeur=21;
//		shape=new Vector <Shape>();
	}
	public abstract JPanelDraw returnJPanel();
	
	public abstract boolean collide();
	
	public abstract Point collidePoint();
}
