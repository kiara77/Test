
public class Ball extends Shape {
	int x,y,radius,dirX,dirY;
	
	public Ball(){
		//TODO a modifier en fonction
		x=10;
		y=10;
		radius=5;
		dirX=1;
		dirY=1;
	}

	public void setDir(int x,int y){
		dirX=x;
		dirY=y;
	}
	
	public void update(){
		x+=dirX;
		y+=dirY;
	}
	public boolean canUpdate(int largeur, int longueur, int UNITE){
		return (x+dirX+radius<=longueur*UNITE && y+dirY<=(largeur-radius)*UNITE);
	}
}
