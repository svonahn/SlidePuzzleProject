import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/*
 * a utility class for images
 */
public class Picture {

	/*
	 * many photos from http://photo.net/photodb/random-photo?category=Pets that
	 * are cute to make puzzled out of
	 * 
	 * research:
	 * http://stackoverflow.com/questions/10292792/getting-image-from-url-java
	 */
	public static String[] URLs = { "http://gallery.photo.net/photo/5932277-lg.jpg",
			"http://gallery.photo.net/photo/1419227-md.jpg", "http://gallery.photo.net/photo/6033655-md.jpg",
			"http://gallery.photo.net/photo/7515971-md.jpg", "http://gallery.photo.net/photo/3085968-lg.jpg",
			"http://gallery.photo.net/photo/6454768-lg.jpg", "http://gallery.photo.net/photo/2708266-lg.jpg",
			"http://gallery.photo.net/photo/7810453-md.jpg", "http://gallery.photo.net/photo/4998919-md.jpg",
			"http://gallery.photo.net/photo/9219226-md.jpg", "http://gallery.photo.net/photo/3174673-md.jpg",
			"http://gallery.photo.net/photo/4190055-lg.jpg", "http://gallery.photo.net/photo/11117390-lg.jpg",
			"http://gallery.photo.net/photo/5791910-md.jpg" };

	/*
	 * returns a string from the set of picture URLs
	 * 
	 * @return string to be turned into a URL
	 */
	public static String getRandomPic() {
		int rand = (int) (Math.random() * URLs.length);
		return URLs[rand];
	}

	/*
	 * splits an image into a grid of smaller images (research:
	 * http://stackoverflow.com/questions/19601116/how-to-draw-part-of-a-large-
	 * buffered image)
	 * 
	 * @param img the image to be split
	 * 
	 * @param sideLength how many smaller images to make per side (there will be
	 * n x n images)
	 * 
	 * @return a list of the smaller images created from the larger image
	 */
	public static ArrayList<BufferedImage> split(BufferedImage img, int sideLength) {
		int width = img.getWidth() / sideLength - 1;
		int height = img.getHeight() / sideLength - 1;

		ArrayList<BufferedImage> squarePics = new ArrayList<BufferedImage>();
		for (int y = 0; y < img.getHeight() - height; y += height) {
			for (int x = 0; x < img.getWidth() - width; x += width) {
				squarePics.add(img.getSubimage(x, y, width, height));
			}
		}
		return squarePics;
	}

	/*
	 * inverts the color of an image (as if creating a negative)
	 * 
	 * @param picture to act on
	 */
	public static void invertColor(BufferedImage img) {
		int width = img.getWidth();
		int height = img.getHeight();

		int originalRGB;
		Color originalColor;
		Color newColor;

		// for each pixel in the image
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				originalRGB = img.getRGB(x, y);
				originalColor = new Color(originalRGB);
				// make opposite color
				newColor = new Color(255 - originalColor.getRed(), 255 - originalColor.getGreen(),
						255 - originalColor.getBlue());
				img.setRGB(x, y, newColor.getRGB());
			}
		}
	}

	/*
	 * creates JComponent representation of an image
	 * 
	 * @param image image to act on
	 * 
	 * @return JComponent represents the parameter image
	 */
	public static JComponent drawablePic(BufferedImage image) {
		JComponent picComp = new JComponent() {
			// apparently necessary
			private static final long serialVersionUID = 1L;

			// method called to represent JComponent
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, this);
			}
		};
		return picComp;
	}
	
	/*
	 * loads a picture from a local file
	 * 
	 * @return an image from file
	 * 
	 * @throws IOException when image cannot be read from file
	 */
	public static BufferedImage loadLocalImage() throws IOException{
			return (BufferedImage)ImageIO.read(new File("pics/beyourownhero.jpg"));
	}
	
	/*
	 * loads a picture from a URL, uses image from file if URL cannot be accessed
	 * 
	 * @return an image to use for a slide puzzle
	 * @throws IOException when image cannot be read from file
	 */
	public static BufferedImage loadImage() throws IOException{
		try {
			// try to get image from URL
			return (BufferedImage) ImageIO.read(new URL(Picture.getRandomPic()));
		} catch (IOException e) {
			// if it doesn't work load image from local file
			return loadLocalImage();
		}
	}
}
