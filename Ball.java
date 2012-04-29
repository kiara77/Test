
public class Ball extends Shape {
	private int x,y,radius,dirX,dirY;
	
	public Ball(){
		//TODO a modifier en fonction
		x=10;
		y=10;
		radius=5;
		dirX=0;
		dirY=1;
	}

	public void setDir(int x,int y){
		dirX=x;
		dirY=y;
	}
	public void setDir(Point dir){
		dirX=dir.getX();
		dirY=dir.getY();
	}
	public Point determineDir(){
		//TODO
		return new Point(0,1);
	}
	public void update(){
//		System.out.println("la");
		x+=dirX;
		y+=dirY;
	}
	public boolean canUpdate(int largeur, int longueur, int UNITE){
		return (x+dirX+radius<=longueur*UNITE && y+dirY<=(largeur-radius)*UNITE);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}
/*
	public void setRadius(int radius) {
		this.radius = radius;
	}
*/
	public int getDirX() {
		return dirX;
	}

	public int getDirY() {
		return dirY;
	}
	
	public boolean isDir(int x, int y){
		return x==dirX && y==dirY;
	}

}
