import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Mouse Listener so the puzzle can respond to clicking
 */
public class Mouse implements MouseListener {

	private Board board;

	public Mouse(Board board) {
		setBoard(board);
		board.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// click location
		int x = e.getX();
		int y = e.getY();

		// corresponding row and column
		int col = x / board.getPieceWidth();
		int row = y / board.getPieceHeight();

		// which square was clicked on
		Square square = board.getPieces()[row][col];

		if (board.areTouching(square, board.getEmptySquare())) {
			board.swap(square, board.getEmptySquare());
		}
		board.repaint();

		// win sequence
		if (board.checkWin()) {
			board.removeMouseListener(this);
			new Thread(new FlashingThread(board)).start();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
