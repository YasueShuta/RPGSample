package animation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AnimSourceImage extends SourceImage {
	int _nx, _ny;
	int _cursor = 0;
	protected BufferedImage[] _animSrc;

	public AnimSourceImage(String filename) {
    super(filename);
  }
	public AnimSourceImage(int w, int h, String filename) {
    this(filename);

    w = w > 0 ? w : 640;
    h = h > 0 ? h : 480;

    setAnimSource(this.w / w, this.h / h);
		
    this.w = w;
    this.h = h;
	}
	
	public void setAnimSource(int nx, int ny) {
    if (nx == 0 || ny == 0) return;
    _nx = nx;
    _ny = ny;
		_animSrc = new BufferedImage[_nx * _ny];
    splitBuffer();
	}

  protected void splitBuffer() {
    w = _src.getWidth() / _nx;
    h = _src.getHeight() / _ny;
		splitBuffer(_src, _animSrc, 0, _nx, _ny);
  }

	protected void splitBuffer(BufferedImage buf, BufferedImage[] out, int offset, int nx, int ny) {
    int w = buf.getWidth() / nx;
    int h = buf.getHeight() / ny;

		for (int i=0; i<ny; i++) {
			for (int j=0; j<nx; j++) {
				out[i*nx + j + offset] = buf.getSubimage(w*j, h*i, w, h);
			}
		}
	}
	
	@Override
	public BufferedImage getImage() {
    if (_nx == 0) return super.getImage();
		return getImage(_cursor % _nx, _cursor / _nx);
	}
	public BufferedImage getImage(int x, int y) {
    if (_animSrc == null) return _src;
		return _animSrc[y * _nx + x];
	}
}
