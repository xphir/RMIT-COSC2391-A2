package diceGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import diceGame.view.DiceGameFrame;
import model.interfaces.GameEngine;

public class ExitController implements ActionListener{

	private DiceGameFrame diceGameFrame;
	private GameEngine model;
	public ExitController(DiceGameFrame diceGameFrame, GameEngine model) {
		this.diceGameFrame=diceGameFrame;
		this.model=model;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	
}
