import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * A component that draws "WINNER"
 */
public class WinnerComponent extends JComponent {

	// apparently this is necessary?
	private static final long serialVersionUID = 1L;

	private Color pink;
	private int x;
	private int y;

	public WinnerComponent(JFrame frame) {
		pink = new Color(255, 0, 100);
		// set Location based on frame size
		x = frame.getWidth() / 2 - 140;
		y = frame.getHeight() / 2 - 60;
	}

	public void paint(Graphics g) {

		// makes sure background is transparent
		setBackground(new Color(0, 0, 0, 0));
		g.setColor(pink);

		// W
		int[] wx = { x + 10, x + 20, x + 30, x + 40, x + 50, x + 60, x + 70, x + 80, x + 65, x + 55, x + 45, x + 35,
				x + 25 };
		int[] wy = { y + 10, y + 10, y + 50, y + 20, y + 20, y + 50, y + 10, y + 10, y + 60, y + 60, y + 30, y + 60,
				y + 60 };

		// I
		int[] ix = { x + 90, x + 90, x + 120, x + 120, x + 110, x + 110, x + 120, x + 120, x + 90, x + 90, x + 100,
				x + 100 };
		int[] iy = { y + 20, y + 10, y + 10, y + 20, y + 20, y + 50, y + 50, y + 60, y + 60, y + 50, y + 50, y + 20 };

		// N
		int[] nx = { x + 130, x + 140, x + 150, x + 150, x + 160, x + 160, x + 150, x + 140, x + 140, x + 130 };
		int[] ny = { y + 10, y + 10, y + 40, y + 10, y + 10, y + 60, y + 60, y + 30, y + 60, y + 60 };

		// N
		int[] n2x = { x + 170, x + 180, x + 190, x + 190, x + 200, x + 200, x + 190, x + 180, x + 180, x + 170 };

		// E
		int[] ex = { x + 210, x + 240, x + 240, x + 220, x + 220, x + 240, x + 240, x + 220, x + 220, x + 240, x + 240,
				x + 210 };
		int[] ey = { y + 10, y + 10, y + 20, y + 20, y + 30, y + 30, y + 40, y + 40, y + 50, y + 50, y + 60, y + 60 };

		// R
		int[] rx = { x + 250, x + 250, x + 270, x + 280, x + 280, x + 270, x + 265, x + 280, x + 270, x + 260, x + 260,
				x + 265, x + 270, x + 270, x + 265, x + 260, x + 260, x + 250 };
		int[] ry = { y + 60, y + 10, y + 10, y + 15, y + 30, y + 35, y + 35, y + 60, y + 60, y + 40, y + 27, y + 27,
				y + 25, y + 20, y + 18, y + 18, y + 60, y + 60 };

		// draw shapes
		g.fillPolygon(wx, wy, wx.length);
		g.fillPolygon(ix, iy, ix.length);
		g.fillPolygon(nx, ny, nx.length);
		g.fillPolygon(n2x, ny, n2x.length);
		g.fillPolygon(ex, ey, ex.length);
		g.fillPolygon(rx, ry, rx.length);
	}
}
