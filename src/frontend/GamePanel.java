package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import backend.BombBox;
import backend.Box;
import backend.Cardinal;
import backend.ContentOperations;
import backend.Game;
import backend.Hole;
import backend.SaveandLoadGame;
import backend.Smile;
import backend.Target;
import backend.Tile;
import backend.Wall;

public class GamePanel extends JPanel {
	private final PanelSwapper swapper;
	private static final long serialVersionUID = 1L;
	private static final int CELL_SIZE = 30;
	private BoardPanel boardpanel;
	private InstanceBoardListener boardlistener;
	private static JLabel statusBar;
	private JLabel levelTitle;
	private final JButton saveButton;
	private final Map<Class, Image> images;
	private Game aGame;
	KeyAdapter ka;

	private GamePanel(final PanelSwapper swapper) {

		images = new HashMap<Class, Image>();

		this.swapper = swapper;
		setLayout(new BorderLayout());

		loadImages(images);

		saveButton = new JButton("Save");
		initSave(saveButton);

		add(saveButton, BorderLayout.EAST);

	}

	// Constructor para partidas cargadas de una guardada

	public GamePanel(final PanelSwapper swapper, final Game aGame)
			throws ClassNotFoundException {
		this(swapper);

		this.aGame = aGame;
		this.boardlistener = new InstanceBoardListener();
		aGame.getBoard().setInstanceBoardListener(boardlistener);

		boardpanel = new BoardPanel(aGame.getBoard().getHeight(), aGame
				.getBoard().getWidth(), CELL_SIZE);
		boardpanel.setBackground(Color.WHITE);
		boardpanel.setGridColor(Color.BLACK);

		boardpanel.setFocusable(true);
		setFocusable(true);

		printBoard(aGame);
		initCellActions();

		levelTitle = new JLabel(aGame.getLevelname(), JLabel.CENTER);
		initLevelTitle(levelTitle);

		statusBar = new JLabel("Jugador: " + aGame.getPlayerName()
				+ ". Puntaje: " + aGame.getScore());

		add(boardpanel, BorderLayout.CENTER);
		add(levelTitle, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
	}

	private void initLevelTitle(JLabel aLabel) {
		aLabel.setFont(new Font(levelTitle.getFont().getFontName(), Font.BOLD,
				18));
		aLabel.setForeground(Color.RED);
		aLabel.setBorder(BorderFactory.createEtchedBorder());
	}

	private void initSave(JButton aButton) {
		aButton.setMnemonic(KeyEvent.VK_S);
		aButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser filesave = new JFileChooser();
				JFrame jframeaux = new JFrame();

				int ret = filesave.showSaveDialog(jframeaux.getContentPane());
				if (ret == JFileChooser.APPROVE_OPTION) {
					File savedGame = filesave.getSelectedFile();
					try {
						SaveandLoadGame sg = new SaveandLoadGame();
						sg.SaveGame(aGame, savedGame.getCanonicalPath());
						setStatusBar("File saved: "
								+ savedGame.getCanonicalPath());
						KeyboardFocusManager.getCurrentKeyboardFocusManager()
								.focusPreviousComponent();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Unable to Save");
						e.printStackTrace();
					}
				}
			}
		});
	}

	private void printBoard(Game aGame) {

		for (int i = 0; i < aGame.getBoard().getHeight(); i++) {
			for (int j = 0; j < aGame.getBoard().getWidth(); j++) {

				Tile tile = aGame.getBoard().getTile(new Point(i, j));

				if (tile instanceof ContentOperations
						&& ((ContentOperations) tile).getContent() instanceof Box) {
					Box aBox = (Box) ((ContentOperations) tile).getContent();
					Image img = null;
					Point point = new Point(aBox.getPosition());
					Tile auxTile = aGame.getBoard().getTile(point);

					img = ImageUtils.dye(images.get(aBox.getClass()),
							aBox.getColor());

					if (aBox instanceof BombBox) {
						String counter = String.valueOf(((BombBox) aBox)
								.getCounter());
						img = ImageUtils.colorize(
								ImageUtils.drawString(
										images.get(BombBox.class), counter,
										Color.WHITE), aBox.getColor());
					}
					if ((auxTile instanceof Target)
							&& (aBox.getColor().equals(((Target) auxTile)
									.getColor()))) {
						img = ImageUtils.increaseBrightness(img);
					}
					boardpanel.appendImage((int) point.getX(),
							(int) point.getY(), img);

				} else if (tile instanceof Target) {
					boardpanel.setImage(i, j, ImageUtils.dye(
							images.get(tile.getClass()),
							((Target) tile).getColor()));
				} else {
					boardpanel.setImage(i, j, images.get(tile.getClass()));
				}
			}
		}

		Point smilePosition = aGame.getBoard().getSmile().getPosition();
		boardpanel.appendImage((int) smilePosition.getX(),
				(int) smilePosition.getY(), images.get(Smile.class));
	}

	private void loadImages(Map<Class, Image> images) {
		try {

			images.put(Box.class, ImageUtils.loadImage("resources/box.png"));
			images.put(Hole.class, ImageUtils.loadImage("resources/hole.png"));
			images.put(BombBox.class,
					ImageUtils.loadImage("resources/box2.png"));
			images.put(Smile.class, ImageUtils.loadImage("resources/smile.gif"));
			images.put(Target.class,
					ImageUtils.loadImage("resources/target.png"));
			images.put(Wall.class, ImageUtils.loadImage("resources/wall.jpg"));

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to Load Images");
			e.printStackTrace();
		}
	}

	private void initCellActions() {
		ka = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					aGame.getBoard().move(Cardinal.EAST);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					aGame.getBoard().move(Cardinal.WEST);
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					aGame.getBoard().move(Cardinal.NORTH);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					aGame.getBoard().move(Cardinal.SOUTH);
				}
				printBoard(aGame);
				setStatusBar("Jugador: " + aGame.getPlayerName()
						+ ". Puntaje: " + aGame.getScore());
				repaint();
			}
		};
		addKeyListener(ka);
	};

	public static void setStatusBar(String text) {
		statusBar.setText(text);
	}

	/**
	 * @return the swapper
	 */
	public PanelSwapper getSwapper() {
		return swapper;
	}
}
