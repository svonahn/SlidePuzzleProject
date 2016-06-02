import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * A board is a collection of squares that makes up a slide puzzle. you can switch a square with the
 * empty square if the two are adjacent
 */
public class Board extends JComponent {

	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private Square[][] pieces;
	private Square emptySquare;
	private JFrame frame;
	private int SIDE_LENGTH;
	private int pieceHeight;
	private int pieceWidth;

	/*
	 * Constructs a board
	 * 
	 * @param img the image to put on the board
	 * 
	 * @param sideLength the side length of the square puzzle (how many pieces
	 * per side)
	 */
	public Board(BufferedImage img, int sideLength) {
		image = img;
		SIDE_LENGTH = sideLength;
		pieces = new Square[SIDE_LENGTH][SIDE_LENGTH];

		ArrayList<BufferedImage> pics = Picture.split(img, SIDE_LENGTH);

		for (int row = 0; row < SIDE_LENGTH; row++) {
			for (int col = 0; col < SIDE_LENGTH; col++) {
				// make the last square empty
				if (pics.size() == 1) {
					pieces[row][col] = new Square(row, col);
					emptySquare = pieces[row][col];
					continue;
				}
				pieces[row][col] = new Square(pics.remove(0), row, col);
			}
		}

		pieceHeight = pieces[0][0].getImage().getHeight();
		pieceWidth = pieces[0][0].getImage().getWidth();

		//shuffle();
	}

	public Square[][] getPieces() {
		return pieces;
	}

	public int getPieceHeight() {
		return pieceHeight;
	}

	public int getPieceWidth() {
		return pieceWidth;
	}

	public void setPieceWidth(int pieceWidth) {
		this.pieceWidth = pieceWidth;
	}

	public void setPieceHeight(int pieceHeight) {
		this.pieceHeight = pieceHeight;
	}

	/*
	 * shuffles the squares to mix up the puzzle to solve
	 */
	private void shuffle() {
		for (int r = SIDE_LENGTH - 1; r >= 0; r--) {
			for (int c = SIDE_LENGTH - 1; c >= 0; c--) {
				int randR = (int) (Math.random() * (r + 1));
				int randC = (int) (Math.random() * (c + 1));
				swap(pieces[r][c], pieces[randR][randC]);
			}
		}
	}

	/*
	 * checks if the puzzle has been completed successfully
	 * 
	 * @return if the player has beat the puzzle yet
	 */
	public boolean checkWin() {
		for (Square[] row : pieces) {
			for (Square square : row) {
				if (!square.inRightSpot()) {
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * switch location of two squares
	 * 
	 * @param square square to move to empty spot
	 * 
	 * @param other other square to swap with square
	 */
	public void swap(Square square, Square other) {
		int tempRow = other.getRow();
		int tempCol = other.getCol();

		other.setLocation(square.getRow(), square.getCol());
		pieces[square.getRow()][square.getCol()] = other;

		square.setLocation(tempRow, tempCol);
		pieces[tempRow][tempCol] = square;
	}

	/*
	 * tells if two squares are touching
	 * 
	 * @param square one square
	 * 
	 * @param other other square
	 */
	public boolean areTouching(Square square, Square other) {
		return (square.getRow() == other.getRow() && Math.abs(square.getCol() - other.getCol()) == 1)
				|| (square.getCol() == other.getCol() && Math.abs(square.getRow() - other.getRow()) == 1);
	}

	/*
	 * how board is displayed as JComponent
	 */
	public void paint(Graphics g) {
		for (Square[] row : pieces) {
			for (Square square : row) {
				square.paint(g);
			}
		}
	}

	public Square getEmptySquare() {
		return emptySquare;
	}

	public BufferedImage getImage() {
		return image;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
