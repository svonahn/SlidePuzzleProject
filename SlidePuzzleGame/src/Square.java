import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/*
 * A square is a puzzle piece. It displays an image and can be moved.
 */
public class Square extends JComponent {

	// it yelled at me to do this???
	private static final long serialVersionUID = 1L;

	private BufferedImage image;

	// original location
	private final int iRow;
	private final int iCol;

	// current location
	private int row;
	private int col;

	// size of square
	private int width;
	private int height;

	private final boolean isEmpty;

	/*
	 * Constructor for squares with picture on them
	 * 
	 * @param pic the sub picture for this square
	 * 
	 * @param theRow the row of this in the original [][] in board
	 * 
	 * @param theCol the column of this in the original [][] in board
	 */
	public Square(BufferedImage img, int theRow, int theCol) {
		image = img;
		iRow = theRow;
		iCol = theCol;
		setLocation(theRow, theCol);
		isEmpty = false;
		width = image.getWidth();
		height = image.getHeight();
	}

	/*
	 * Constructor for an empty square (bottom right)
	 * 
	 * @param theRow the row of this in the original [][] in board (bottom)
	 * 
	 * @param theCol the column of this in the original [][] in board
	 * (rightmost)
	 */
	public Square(int theRow, int theCol) {
		image = null;
		iRow = theRow;
		iCol = theCol;
		setLocation(theRow, theCol);
		isEmpty = true;
	}

	public int getiCol() {
		return iCol;
	}

	public int getiRow() {
		return iRow;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public void setLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public BufferedImage getImage() {
		return image;
	}

	/*
	 * tells if this square is in the right spot to complete the puzzle
	 * 
	 * @return if the square is in the right spot
	 */
	public boolean inRightSpot() {
		return row == iRow && col == iCol;
	}

	/*
	 * how square will be displayed 
	 * researched: http://www.java2s.com/
	 */
	public void paint(Graphics g) {
		g.drawImage(image, col * width, row * height, this);
	}
}
