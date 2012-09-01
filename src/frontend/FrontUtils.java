package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import parser.GameParser;
import backend.Board;
import backend.Game;
import backend.Player;
import backend.SaveandLoadGame;
import exceptions.GameParserException;

public class FrontUtils {

	public static void exit(JButton aButton) {
		aButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}

	public static void exit(JMenuItem anItem) {
		anItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}

	public static void load(JButton aButton, final PanelSwapper swapper) {
		aButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser fileopen = new JFileChooser();
				JFrame jframeaux = new JFrame();

				int ret = fileopen.showDialog(jframeaux.getContentPane(),
						"Load game");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File loadedGame = fileopen.getSelectedFile();
					SaveandLoadGame play = new SaveandLoadGame();
					Game aGame = null;
					try {
						aGame = play.LoadGame(loadedGame.getCanonicalPath());
						swapper.newGame(aGame);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Unable to Load File");
						e.printStackTrace();
					}
					GamePanel.setStatusBar("File loaded: "
							+ loadedGame.getAbsolutePath());
				}
			}
		});
	}

	public static void load(JMenuItem anItem, final PanelSwapper swapper) {
		anItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser fileopen = new JFileChooser();
				JFrame jframeaux = new JFrame();

				int ret = fileopen.showDialog(jframeaux.getContentPane(),
						"Load game");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File loadedGame = fileopen.getSelectedFile();
					SaveandLoadGame play = new SaveandLoadGame();
					Game aGame = null;
					try {
						aGame = play.LoadGame(loadedGame.getCanonicalPath());
						swapper.newGame(aGame);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "load");
						e.printStackTrace();
					}
					GamePanel.setStatusBar("File loaded: "
							+ loadedGame.getAbsolutePath());
				}
			}
		});
	}

	public static void createNew(JButton aButton, final PanelSwapper swapper) {
		aButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				String enteredText;
				boolean cancel = false;
				do {
					enteredText = JOptionPane.showInputDialog(null,
							"Ingrese su nombre:", "Nuevo Juego",
							JOptionPane.QUESTION_MESSAGE);
					if (enteredText == null)
						cancel = true;

				} while (!cancel
						&& (enteredText.equals("") || enteredText.contains("#") || enteredText
								.contains(",")));

				if (enteredText != null) {
					JFileChooser fileopen = new JFileChooser();
					fileopen.setCurrentDirectory(new File("./levels"));
					fileopen.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileopen.setDialogTitle("Nuevo Juego");

					JFrame jframeaux = new JFrame();

					int ret = fileopen.showDialog(jframeaux.getContentPane(),
							"New game");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File loadedGame = fileopen.getSelectedFile();
						GameParser parser = new GameParser();
						try {
							Board board = parser.readFiles(loadedGame);
							Game aGame = new Game(board,
									new Player(enteredText), loadedGame
											.getName());
							swapper.newGame(aGame);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null,
									"Unable to create game");
							e.printStackTrace();
						} catch (GameParserException e) {
							JOptionPane
									.showMessageDialog(null,
											"Unable to create game - Invalide File Type");
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null,
									"Unable to create game");
							e.printStackTrace();
						}
					}

				}
			}
		});
	}

	public static void createNew(JMenuItem anItem, final PanelSwapper swapper) {
		anItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				String enteredText;
				boolean cancel = false;
				do {
					enteredText = JOptionPane.showInputDialog(null,
							"Ingrese su nombre:", "Nuevo Juego",
							JOptionPane.QUESTION_MESSAGE);
					if (enteredText == null)
						cancel = true;

				} while (!cancel
						&& (enteredText.equals("") || enteredText.contains("#") || enteredText
								.contains(",")));

				if (enteredText != null) {
					JFileChooser fileopen = new JFileChooser();
					fileopen.setCurrentDirectory(new File("./levels"));
					fileopen.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileopen.setDialogTitle("Nuevo Juego");

					JFrame jframeaux = new JFrame();

					int ret = fileopen.showDialog(jframeaux.getContentPane(),
							"New game");
					if (ret == JFileChooser.APPROVE_OPTION) {
						File loadedGame = fileopen.getSelectedFile();
						GameParser parser = new GameParser();
						try {
							Board board = parser.readFiles(loadedGame);
							Game aGame = new Game(board,
									new Player(enteredText), loadedGame
											.getName());
							swapper.newGame(aGame);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null,
									"Could not create new game");
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null,
									"Could not create new game");
							e.printStackTrace();
						}
					}
				}
			}
		});
	}

	/**
	 * public static void invalidPath() { JOptionPane.showMessageDialog(null,
	 * "No se puede salvar un juego dentro de la carpeta " +
	 * "'levels'.\nVuelve a intentarlo.", "Error!", JOptionPane.ERROR_MESSAGE);
	 * }
	 */
	public static void about(JMenuItem anItem) {
		anItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null,
						"Trabajo Practico especial\nProgramacion "
								+ "Orientada a Objetos.\n\nDaniel Lobo - "
								+ "Teresa C. Di Tada - Felipe Martinez\n      "
								+ "                            2012",
						"About Sokoban", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

}
