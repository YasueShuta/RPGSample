package animation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AnimSourceImage extends SourceImage {
	int _nx, _ny;
	int _cursor = 0;
	protected BufferedImage[] _src;

	public AnimSourceImage(String filename) {
		this(640, 480, filename);
	}
	public AnimSourceImage(int w, int h, String filename) {
		this.w = w > 0 ? w : 640;
		this.h = h > 0 ? h : 480;
		
		BufferedImage buf;
		try {
			buf = ImageIO.read(new File(filename));
			
			_nx = buf.getWidth() / w;
			_ny = buf.getHeight() / h;

			setSource(buf);
		} catch (IOException e) {
			System.err.println("Resource File: " + filename);
			e.printStackTrace();
		}		
	}
	
	protected void setSource(BufferedImage buf) {
		_src = new BufferedImage[_nx * _ny];
		splitBuffer(buf, _src, 0, _nx, _ny);
	}

	protected void splitBuffer(BufferedImage buf, BufferedImage[] out, int offset, int nx, int ny) {
		for (int i=0; i<ny; i++) {
			for (int j=0; j<nx; j++) {
				out[i*nx + j + offset] = buf.getSubimage(w*j, h*i, w, h);
			}
		}
	}
	
	@Override
	public BufferedImage getImage() {
		return getImage(_cursor % _nx, _cursor / _nx);
	}
	public BufferedImage getImage(int x, int y) {
//		System.out.println(x + ", " + y);
		return _src[y * _nx + x];
	}

}
