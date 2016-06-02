import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

//has tested may things. currently just showing winner message

public class EmptyFrame {
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setPreferredSize(new Dimension(1000, 1000));
	    
	    WinnerComponent comp = new WinnerComponent(frame);
	    comp.setSize(layeredPane.getPreferredSize());
	    comp.setLocation(0, 0);

	    layeredPane.add(comp, JLayeredPane.DRAG_LAYER);
	    frame.setLayeredPane(layeredPane);
	    frame.setVisible(true);
	}
}
