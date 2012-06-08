package frontend;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PanelSwapper swapper;

	public WelcomePanel(final PanelSwapper swapper) {

		this.swapper = swapper;
		setLayout(new GridLayout(2, 2));
		initNew();
		initLoad();
		initQuit();

	}

	private void initNew() {
		JButton button = new JButton("Nuevo Juego", new ImageIcon(
				System.getProperty("user.dir") + "/resources/newgameicon.png"));
		FrontUtils.createNew(button, swapper);
		add(button);
	}

	private void initLoad() {
		JButton button = new JButton("Cargar Juego", new ImageIcon(
				System.getProperty("user.dir") + "/resources/loadgameicon.png"));
		FrontUtils.load(button, swapper);
		add(button);
	}

	private void initQuit() {
		JButton button = new JButton("Salir", new ImageIcon(
				System.getProperty("user.dir") + "/resources/quiticon.png"));
		FrontUtils.exit(button);
		add(button);
	}
}