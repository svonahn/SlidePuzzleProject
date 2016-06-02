import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

/*
 * Runs puzzle game
 */
public class Game {

	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

		Scanner scan = new Scanner(System.in);
		System.out.println("What size puzzle do you want?\ne.g. For a 2x2 puzzle type '2'");
		int side = 0;

		// research:
		// http://stackoverflow.com/questions/2496239/how-do-i-keep-a-scanner-from-throwing-exceptions-when-the-wrong-type-is-entered
		// http://www.tutorialspoint.com/java/util/scanner_nextint.htm
		while (scan.hasNext()) {
			//if it's not a number
			if (!scan.hasNextInt()) {
				System.out.println("Sorry, " + scan.next() + " is not a number!");
				continue;
			}
			side = scan.nextInt();
			//if invalid number
			if (side < 2 || side > 12) {
				System.out.println("Invalid size, try again.");
				continue;
			}
			//it is a valid number! hooray!
			break;
		} 
		final int realSide = side;
		scan.close();

		Music.play();

		// set up game
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// get image to use
				BufferedImage image;
				try {
					image = Picture.loadImage();
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}

				// create board
				Board board = new Board(image, realSide);

				JFrame frame = new JFrame();
				board.setFrame(frame);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(image.getWidth(), image.getHeight());
				// set up layers
				JLayeredPane layeredPane = new JLayeredPane();
				layeredPane.setPreferredSize(new Dimension(1000, 1000));
				// set layout for board
				board.setSize(layeredPane.getPreferredSize());
				board.setLocation(0, 0);
				// implement layeredPane
				layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
				frame.setLayeredPane(layeredPane);
				frame.setVisible(true);
				// add mouse listener
				@SuppressWarnings("unused")
				Mouse mouse = new Mouse(board);

			}
		});
	}

}
