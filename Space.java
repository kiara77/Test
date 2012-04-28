public abstract class Space {
	int longueur;
	int largeur;
	final int UNITE = 5;
	Obstacles obstacles;
//	Vector <Shape> shape;
	Ball ball;
	
	Space(){
		ball = new Ball();
		longueur=122;
		largeur=137;
//		shape=new Vector <Shape>();
	}
	public abstract JPanelDraw returnJPanel();
	
	public abstract boolean collide();
	
	public abstract Point collidePoint();
}
