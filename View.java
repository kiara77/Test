import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;

import org.w3c.dom.ls.LSSerializer;
public class View extends JFrame implements ActionListener{
	Timer timer; 
	int delay = 500;
	
	private static final long serialVersionUID = 1L;
	protected GraphicsEnvironment graphicsEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();//get local graphics environment	
	protected Rectangle maxWindowBounds=graphicsEnv.getMaximumWindowBounds();//get maximum window bounds
	protected int hauteur = (int)maxWindowBounds.getHeight();
	protected int largeur = (int)maxWindowBounds.getWidth();
	LevelState ls;
	Space space;

	public View(LevelState levelState) throws FileNotFoundException{
		timer = new Timer(delay,this);
		timer.start(); 
		this.ls=levelState;
		ls.space = levelState.spaceFromFile(1);
		super.setTitle("Projet Long");
		super.setSize(largeur,hauteur);
		super.setResizable(true);
		super.setBackground(Color.WHITE);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void construit(){
		super.setContentPane(ls.space.returnJPanel());
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == timer)	{
			//verifier collision
			System.out.println("je decale");
			ls.space.ball.update();
			repaint();
			validate();
		}		
	}
}
