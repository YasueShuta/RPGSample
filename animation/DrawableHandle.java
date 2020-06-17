package animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawableHandle implements IDrawable {
	protected SourceImage _srcimg;
	int[] _pos = {0, 0};
	double _scale;

	public DrawableHandle() {
	}
	public DrawableHandle(String filename, double scale) {
		_srcimg = new SourceImage(filename);
		_scale = scale;
	}

	public double scale() {
		return _scale;
	}
	public void scale(double scale) {
		_scale = scale;
	}
	
	@Override
	public int[] pos() {
		return _pos;
	}
	@Override
	public void pos(int x, int y) {
		_pos[0] = x;
		_pos[1] = y;
	}

	@Override
	public void draw(Graphics g) {
		BufferedImage img = _srcimg.getImage();

		double dw = img.getWidth() * _scale;
		double dh = img.getHeight() * _scale;
		double dx = _pos[0] - dw/2;
		double dy = _pos[1] - dh/2;
		
		g.drawImage(img,
				(int)dx, (int)dy, (int)dw, (int)dh, null);

	}
	
	protected void drawImage(Graphics g, BufferedImage img) {
	
	}

}
