package frontend;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static PanelSwapper swapper;
	private JMenu game;
	private JMenu help;

	public MainWindow() throws IOException, ClassNotFoundException {
		super("Sokoban");

		setSize(400, 450);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Estas lineas setean el JFrame en el medio
		 */
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2
				- getHeight() / 2);
		
		swapper = new PanelSwapper(); 
		setContentPane(swapper); 

		initMenu();
		setResizable(false);

	}

	private void initMenu() {

		JMenuBar menubar = new JMenuBar();

		game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);

		initNew();
		initLoad();
		game.addSeparator();
		initQuit();

		menubar.add(game);

		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		initWelcome();
		help.addSeparator();
		initAbout();

		menubar.add(help);
		this.setJMenuBar(menubar);

	}

	private void initNew() {
		JMenuItem item = new JMenuItem("New Game");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		FrontUtils.createNew(item, swapper);
		game.add(item);
	}

	private void initLoad() {
		JMenuItem item = new JMenuItem("Load");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		FrontUtils.load(item, swapper);
		game.add(item);
	}

	private void initQuit() {
		JMenuItem item = new JMenuItem("Quit");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		FrontUtils.exit(item);
		game.add(item);
	}

	private void initAbout() {
		JMenuItem item = new JMenuItem("About");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		FrontUtils.about(item);
		help.add(item);
	}

	private void initWelcome() {
		JMenuItem item = new JMenuItem("Welcome screen");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				swapper.changePanel("welcome");
			}
		});
		help.add(item);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		JFrame window = new MainWindow();
		window.setVisible(true);
	}
}

