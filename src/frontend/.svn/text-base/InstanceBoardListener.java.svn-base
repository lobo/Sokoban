package frontend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import frontend.PanelSwapper;

import backend.BoardListener;

public class InstanceBoardListener implements BoardListener{
	
	private static PanelSwapper swapper;
	
	@Override
	public void win(String LevelName, int score) {
		frameCreator("Ganaste!");
	}

	@Override
	public void gameOver() {
		frameCreator("Perdiste!");
	}
	
	private void frameCreator(String text){
		JOptionPane.showMessageDialog(null, text);
		System.exit(0);
	}
}
