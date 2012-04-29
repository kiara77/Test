import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;

public class View extends JFrame{

	
	private static final long serialVersionUID = 1L;
	protected GraphicsEnvironment graphicsEnv=GraphicsEnvironment.getLocalGraphicsEnvironment();//get local graphics environment	
	protected Rectangle maxWindowBounds=graphicsEnv.getMaximumWindowBounds();//get maximum window bounds
	protected int hauteur = (int)maxWindowBounds.getHeight();
	protected int largeur = (int)maxWindowBounds.getWidth();
	LevelState ls;

	public View(LevelState levelState) throws FileNotFoundException{
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
}
