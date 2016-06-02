import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTester {

	public static void main(String[] args) throws IOException {
		BufferedImage image = (BufferedImage) ImageIO.read(new File("pics/beyourownhero.jpg"));
		Board board = new Board(image, 3);
		Picture.invertColor(image);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(image.getWidth(), image.getHeight());
		JComponent drawableImage = Picture.drawablePic(image);
		frame.add(drawableImage);
		frame.remove(board);
		frame.setVisible(true);
	}
}
