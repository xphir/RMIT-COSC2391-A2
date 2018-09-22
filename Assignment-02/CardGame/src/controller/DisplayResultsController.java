package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.CardGameFrame;


//Display results including updated player balances after house deal
public class DisplayResultsController implements ActionListener   {
	private CardGameFrame cardGameFrame;
	private GameEngine model;
	
	public DisplayResultsController(CardGameFrame cardGameFrame, GameEngine model) {
		this.cardGameFrame = cardGameFrame;
		this.model = model;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
