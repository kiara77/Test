import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Timer;


public class LevelManager implements ActionListener{
	Timer timer; 
	int delay = 1050;
	View view;
	LevelState levelState;
	GameRules gameRules;
	
	public LevelManager() throws FileNotFoundException{
		levelState = new LevelState(2);
		view = new View(levelState);
		gameRules = new GameRules();
		timer = new Timer(delay,this);
		timer.start(); 
	}
	public void play(){
		view.construit();
		while(!gameRules.gameOver(levelState)){
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == timer)	{
			if(levelState.space.collide()){
				Point pointCollide = levelState.space.collidePoint();
				//FIXME ne pas modifier la direction dans l'affichage
				//TODO envoyer les(quelques) pixels qui entourent le point d'impact de la balle puis 
				//determiner la direction selon explicationRebondObstacle.jpg ?
				levelState.space.ball.setDir(levelState.space.obstacles.collisionNewDirBall(levelState.space.ball, pointCollide));
			}
			if(levelState.space.ball.canUpdate(levelState.space.largeur,levelState.space.longueur,levelState.space.UNITE)){
				//System.out.println("je decale");
				levelState.space.ball.update();
			}
			view.repaint();
			view.validate();
		}
	}
}
