import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CharacterImage {
	public int w,h;
	
	BufferedImage resource = null;
	BufferedImage[] buf;
	
	static int nx = 3, ny = 4;
	static int[] order = {1, 0, 1, 2};
	static HashMap<String, Integer> direction = new HashMap<>();
	static {
		direction.put("down", 0);
		direction.put("left", 1);
		direction.put("right", 2);
		direction.put("up", 3);
	}
	
	public CharacterImage(String resourceFile) {
		try {
			resource = ImageIO.read(new File(resourceFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		w = resource.getWidth() / nx;
		h = resource.getHeight() / ny;
		
		buf = new BufferedImage[nx * ny];
		
		for (int i=0; i < ny; i++) {
			for (int j=0; j < nx; j++) {
				buf[i*nx + j] = resource.getSubimage(w*j, h*i, w, h);
			}
		}
	}
	
	public BufferedImage getImage(String d, int t) {
		int x = order[t % 4];
		int y = direction.get(d);

		return buf[y*nx + x];
	}
}
