package frontend;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JPanel;

import backend.Game;

import frontend.WelcomePanel;

public class PanelSwapper extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final JPanel WelcomePanel1;
	private JPanel GamePanel1;

	public PanelSwapper() throws IOException, ClassNotFoundException {

		super(new CardLayout());

		WelcomePanel1 = new WelcomePanel(this);
		add(WelcomePanel1, "welcome");
		changePanel("welcome");

	}

	public void changePanel(String panelCode) {
		CardLayout cl = (CardLayout) (getLayout());
		cl.show(this, panelCode);
	}

	
	public void newGame(Game aGame) throws IOException, ClassNotFoundException {
		GamePanel1 = new GamePanel(this, aGame);
		add(GamePanel1, "game");
		changePanel("game");
	}
}
