package animation;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class CharacterImage extends SourceImage {
	BufferedImage[] buf;
	
	public static int nx = 3, ny = 4;
	public static int[] order = {1, 0, 1, 2};
	public static HashMap<String, Integer> direction = new HashMap<>();
	static {
		direction.put("down", 0);
		direction.put("left", 1);
		direction.put("right", 2);
		direction.put("up", 3);
	}
	
	public CharacterImage(String filename) {
		super(filename);
		w = w / nx;
		h = h / ny;
		
		buf = new BufferedImage[nx * ny];
		
		for (int i=0; i < ny; i++) {
			for (int j=0; j < nx; j++) {
				buf[i*nx + j] = _src.getSubimage(w*j, h*i, w, h);
			}
		}
	}
	
	@Override
	public BufferedImage getImage() {
		return getImage("down", 0);
	}

	public BufferedImage getImage(String d, int t) {
		int x = order[t % 4];
		int y = direction.get(d);

		return buf[y*nx + x];
	}
	
	public static CharacterImage loadChara(String name) {
		String filename = CharaImageFile.BASENAME + name + CharaImageFile.EXT;
		return new CharacterImage(filename);
	}
}
