import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class WinTester {
	
	//comment out shuffle from board constructor!!!
	
	//http://stackoverflow.com/questions/7938825/graphics-not-showing-in-jlayeredpane-java-swing
	//http://docs.oracle.com/javase/tutorial/uiswing/components/layeredpane.html
	//http://stackoverflow.com/questions/16455614/jlayeredpane-with-jpanel-and-jlabel-with-icon
	
	public static void main(String[] args) throws IOException {
		
		BufferedImage image = (BufferedImage)ImageIO.read(new File("pics/beyourownhero.jpg"));
		Board board = new Board(image, 3);
		//one move away
		board.swap(board.getPieces()[2][2], board.getPieces()[2][1]);
		
		//make sure win is recognized
		/*System.out.println(board.checkWin());
		board.swap(board.getPieces()[2][2], board.getPieces()[2][1]);
		System.out.println(board.checkWin());
		*/
		
		//set up display
		JFrame frame = new JFrame();
		board.setFrame(frame);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(image.getWidth(), image.getHeight());
	    
	    JLayeredPane layeredPane = new JLayeredPane();  
	    layeredPane.setPreferredSize(new Dimension(1000,1000));
	    board.setSize(layeredPane.getPreferredSize());
	    board.setLocation(0,0);
	    layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
	    frame.setLayeredPane(layeredPane);
	    frame.setVisible(true);
	    
	    //test if you can click to win and it works
	    	@SuppressWarnings("unused")
	    	Mouse mouse = new Mouse(board);
	}
}
