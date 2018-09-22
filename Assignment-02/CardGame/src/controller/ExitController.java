package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CardGameFrame;
import model.interfaces.GameEngine;

public class ExitController implements ActionListener{
	private CardGameFrame cardGameFrame;
	private GameEngine model;
	
	public ExitController(CardGameFrame cardGameFrame, GameEngine model) {
		this.cardGameFrame=cardGameFrame;
		this.model=model;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	
}
