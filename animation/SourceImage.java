package animation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceImage {
	int w, h;
	
	protected BufferedImage _src = null;

	public SourceImage() {}
	public SourceImage(String filename) {
		try { 
			_src = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.err.println("Resource File: " + filename);
			e.printStackTrace();
		}
		w = _src.getWidth();
		h = _src.getHeight();
	}
	
	public BufferedImage getImage() {
		return _src;
	}
}
