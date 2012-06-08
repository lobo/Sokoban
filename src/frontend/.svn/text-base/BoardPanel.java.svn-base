package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import exceptions.PositionOutOfBoundsException;

import backend.Cardinal;

/**
 * Panel que permite representar un tablero de N x M celdas. Permite colocar
 * imagenes en las celdas y superponer imagenes con transparencia. Ofrece una
 * interfaz para notificar eventos ocurridos en las celdas (clic y arrastrar).
 * 
 * Los metodos {@code clearImage}, {@code setImage} y {@code appendImage}
 * requieren que se repinte el panel para poder ver los cambios, por lo tanto
 * luego de operar con los mismos se debe invocar al metodo repaint.
 */

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int cellSize;
	private final int rows, columns;
	private Color gridColor = Color.BLACK;
	private final Image[][] cells;
	

	/**
	 * Crea un nuevo panel con una cantidad determinada de filas y columnas. El
	 * parametro cellSize indica el ancho y alto en pixels de las celdas.
	 */
	public BoardPanel(int rows, int columns, int cellSize) {
		this.rows = rows;
		this.columns = columns;
		this.cellSize = cellSize;
		this.cells = new Image[rows][columns];

		setSize(columns * cellSize + 1, rows * cellSize + 1);
	}

	/**
	 * Elimina el contenido de una celda determinada.
	 */
	public void clearImage(int row, int column) {
		checkValidCell(row, column);
		cells[row][column] = null;
	}

	/**
	 * Coloca una imagen en una celda determinada. Si la celda ya contenia otra
	 * imagen, la reemplaza.
	 */
	public void setImage(int row, int column, Image image) {
		checkValidCell(row, column);
		cells[row][column] = new BufferedImage(cellSize, cellSize,
				BufferedImage.TYPE_INT_ARGB);
		cells[row][column].getGraphics().drawImage(image, 0, 0, null);
	}

	/**
	 * Establece el color de la grilla.
	 */
	public void setGridColor(Color gridColor) {
		this.gridColor = gridColor;
	}

	/**
	 * Superpone una imagen sobre una celda. Si la celda esta vacia, es
	 * equivalente a usar {@code setCell}. Si la celda no esta vacia y la imagen
	 * a superponer contiene transparencias, entonces se superpone la imagen
	 * encima de la existente.
	 */
	public void appendImage(int row, int column, Image image) {
		checkValidCell(row, column);
		if (cells[row][column] == null) {
			cells[row][column] = new BufferedImage(cellSize, cellSize,
					BufferedImage.TYPE_INT_ARGB);
		}
		cells[row][column].getGraphics().drawImage(image, 0, 0, null);
	}

	/**
	 * Valida que una coordenada de celda pertenezca al tablero.
	 */
	private void checkValidCell(int row, int column) {
		if (row >= rows || column >= columns || row < 0 || column < 0) {
			throw new IllegalArgumentException("Invalid cell.");
		}
	}
	

	/**
	 * @see JPanel#paint(Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		/* Dibujar la grilla. */
		g.setColor(gridColor);
		for (int i = 0; i <= rows; i++) {
			g.drawLine(0, i * cellSize, columns * cellSize, i * cellSize);
		}
		for (int j = 0; j <= columns; j++) {
			g.drawLine(j * cellSize, 0, j * cellSize, rows * cellSize);
		}

		/* Dibujar las celdas. */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (cells[i][j] != null) {
					g.drawImage(cells[i][j], j * cellSize, i * cellSize, null);
				}
			}
		}
	}
}