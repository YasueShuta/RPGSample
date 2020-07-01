package animation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawableHandle implements IDrawable {
	private boolean _visible = true;
	int _w, _h;
	
	protected SourceImage _srcimg;
	int[] _pos = {0, 0};
	double _scale = 1.0;

	public DrawableHandle() {
	}
	public DrawableHandle(String filename, double scale) {
		_srcimg = new SourceImage(filename);
		_scale = scale;
	}

	@Override
	public double scale() {
		return _scale;
	}
	@Override
	public void scale(double scale) {
		_scale = scale;
	}
	
	@Override
	public Dimension size() {
		return new Dimension(_w, _h);
	}
	@Override
	public void size(int w, int h) {
		_w = w;
		_h = h;
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

		int dw = _w > 0 ? _w : (int) (img.getWidth() * _scale);
		int dh = _h > 0 ? _h : (int) (img.getHeight() * _scale);
		double dx = _pos[0] - dw/2;
		double dy = _pos[1] - dh/2;
		
		g.drawImage(img,
				(int)dx, (int)dy, dw, dh, null);

	}
	
	@Override
	public boolean isVisible() {
		return _visible;
	}
	@Override
	public void setVisible(boolean v) {
		_visible = v;
	}

}
