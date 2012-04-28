import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;

public class View extends JFrame implements ActionListener{
	Timer timer; 
	int delay = 250;
	
	private static final long serialVersionUID = 1L;
	protected GraphicsEnvironment graphicsEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();//get local graphics environment	
	protected Rectangle maxWindowBounds=graphicsEnv.getMaximumWindowBounds();//get maximum window bounds
	protected int hauteur = (int)maxWindowBounds.getHeight();
	protected int largeur = (int)maxWindowBounds.getWidth();
	LevelState ls;

	public View(LevelState levelState) throws FileNotFoundException{
		timer = new Timer(delay,this);
		timer.start(); 
		this.ls=levelState;
		super.setTitle("Projet Long");
		super.setSize(largeur,hauteur);
		super.setResizable(true);
		super.setBackground(Color.WHITE);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void construit(){
		super.setContentPane(ls.space.returnJPanel());
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == timer)	{
			if(ls.space.collide()){
				Point pointCollide = ls.space.collidePoint();
				//TODO direction a modifier selon logique (0,1) test
				//FIXME ne pas modifier la direction dans l'affichage
				ls.space.ball.setDir(0,1);
			}
			if(ls.space.ball.canUpdate(ls.space.largeur, ls.space.longueur, ls.space.UNITE)){
				//System.out.println("je decale");
				ls.space.ball.update();
			}
			repaint();
			validate();
		}		
	}
}
