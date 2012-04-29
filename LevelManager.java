import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Timer;


public class LevelManager implements ActionListener{
	Timer timer; 
	int delay = 550;
	View view;
	LevelState levelState;
	GameRules gameRules;
	public LevelManager(int numLevel) throws FileNotFoundException{
		levelState = new LevelState(numLevel);
		view = new View(levelState);
		gameRules = new GameRules();
		timer = new Timer(delay,this);
		timer.start(); 
	}
	public void playLevel(){
		view.construit();	
		while(!gameRules.gameOver(levelState)&&!levelState.isFinish()){
			
		}
		System.out.println("niveau fini");
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
