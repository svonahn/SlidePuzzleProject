import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

class SquareTester {

	public static void main(String[] args) throws IOException 
	{
		BufferedImage image = (BufferedImage) ImageIO.read(new File("pics/beyourownhero.jpg"));

		ArrayList<BufferedImage> pics = Picture.split(image, 3);

		ArrayList<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < pics.size(); i++) {
			squares.add(new Square(pics.get(i), i / 3, i % 3));
		}

		//make sure they are same picture
		Picture.invertColor(pics.get(0));
		Picture.invertColor(squares.get(0).getImage());
		
		//check square methods. make sure in right order and start in right spot
		for (Square square : squares) {
			System.out.println(square.getRow() + " " + square.getCol() + " " + square.inRightSpot());
		}

		// test shuffle (board should be shuffled)

		@SuppressWarnings("unused")
		Board board = new Board(image, 3);
	}
}
