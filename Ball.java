
public class Ball extends Shape {
	int x,y,radius,dirX,dirY;
	
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
}
