import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//many different tests going on

@SuppressWarnings("unused")
public class PicTester {

	public static void main(String[] args) throws IOException {

		// picture from URL
		BufferedImage image = (BufferedImage) ImageIO.read(new URL("http://gallery.photo.net/photo/5932277-lg.jpg"));
		// picture from file
		// BufferedImage image = (BufferedImage)ImageIO.read(new
		// File("pics/beyourownhero.jpg"));

		// see if square will work correctly
		// Square square = new Square(image, 0, 0);

		// make a board out of the picture
		Board board = new Board(image, 3);

		JLayeredPane layers = new JLayeredPane();

		// java2s.com. just need for tester
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(image.getWidth(), image.getHeight());

		// attempt at adding things to layered pane
		/*
		 * layers.add(board, 1,0); layers.add(new WinnerComponent(frame), 2,0);
		 * layers.setVisible(true); frame.add(layers);
		 */

		// attempt at adding things to JPanel before adding to JFrame
		JPanel panel = new JPanel();
		// panel.setBackground(new Color(0,0,0,65));
		// panel.setLayout(new FlowLayout());
		// panel.add(new WinnerComponent(frame));

		// attempt to just add components to the frame
		frame.add(board);
		frame.add(new WinnerComponent(frame));
		// frame.add(panel);

		frame.setVisible(true);

		Mouse mouse = new Mouse(board);
		board.setFrame(frame);

		// start win sequence manually
		// new Thread(new FlashingThread(board)).start();

		// try to add board to one frame but win component to another
		/*
		 * JFrame framer = new JFrame(); board.swap(board.getPieces()[0][0],
		 * board.getPieces()[2][2]);
		 * framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * framer.setSize(image.getWidth(), image.getHeight());
		 * framer.add(board); framer.setVisible(true);
		 */
	}
}
