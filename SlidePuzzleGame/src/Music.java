
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/*
 * make music play continuously
 * 
 *resources used include:
 *http://www.java2s.com/Code/Java/Development-Class/
 *AnexampleofloadingandplayingasoundusingaClip.htm
 *http://stackoverflow.com/tags/javasound/info
 */
public class Music {
	public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		File file = new File("Songs/Disney_Themes_-_Supercalifragilisticexpialidocious.mid");
		AudioInputStream sound = AudioSystem.getAudioInputStream(file);

		DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
		Clip clip = (Clip) AudioSystem.getLine(info);
		clip.open(sound);

		clip.addLineListener(new LineListener() {
			// manual stopping mechanism
			public void update(LineEvent event) {
				if (event.getType() == LineEvent.Type.STOP) {
					event.getLine().close();
					System.exit(0);
				}
			}
		});
		// loop song
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
