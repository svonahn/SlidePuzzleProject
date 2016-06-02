import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/*
 * An event sequence to start after a player wins the puzzle game.
 * The picture will fill in the final square and will flash.
 * A winner message will be displayed.
 * 
 */

public class FlashingThread implements Runnable {

	private Board board;

	public FlashingThread(Board board) {
		this.board = board;
	}

	/*
	 * This method is called when you start the thread.
	 */
	@Override
	public void run() {

		JFrame frame = board.getFrame();
		BufferedImage image = board.getImage();
		JLayeredPane layeredPane = frame.getLayeredPane();

		// winner message
		WinnerComponent comp = new WinnerComponent(frame);
		// need to configure layout
		comp.setSize(layeredPane.getPreferredSize());
		comp.setLocation(0, 0);
		// add to top
		layeredPane.add(comp, JLayeredPane.DRAG_LAYER);

		// add entire picture
		JComponent pic = Picture.drawablePic(image);
		// configure layout
		pic.setSize(layeredPane.getPreferredSize());
		pic.setLocation(0, 0);
		// add to background
		layeredPane.add(pic, JLayeredPane.DEFAULT_LAYER);
		// take out incomplete board
		frame.remove(board);

		// for a lot of times
		while (true) {
			Picture.invertColor(image);
			frame.repaint();
			try {
				// sleep 30 milliseconds
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// if it doesn't work tell me it doesn't work
				e.printStackTrace();
			}
		}
	}
}
