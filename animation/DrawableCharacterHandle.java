package animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawableCharacterHandle extends DrawableHandle {
	protected CharacterImage _srcimg;
	protected CharacterImage _shadow = null;
	protected int _direction = 0;
	protected int _timing = 0;
	protected int _state = 0;
		
	public DrawableCharacterHandle() {
		this(CharaImageFile.YOUNG_MAN);
	}
	public DrawableCharacterHandle(String name) {
		this(name, ShadowImageFile.DEFAULT);
	}
	public DrawableCharacterHandle(String name, String shadowname){
		_srcimg = CharacterImage.loadChara(name);
		
		if (shadowname != "") {
			String shadowFile = ShadowImageFile.BASENAME + shadowname + ShadowImageFile.EXT;
			_shadow = new CharacterImage(shadowFile);
		}
	}
	

	@Override
	public void draw(Graphics g) {
		BufferedImage img = _srcimg.getImage();
		
		double dw = img.getWidth() * _scale;
		double dh = img.getHeight() * _scale;
		double dx = _pos[0] - dw/2;
		double dy = _pos[1] - dh/2;

		if (_shadow != null) {
			double dy2 = _pos[1] - dh/2 * 0.85;
			g.drawImage(_shadow.getImage(),
					(int)dx, (int)dy2, (int)dw, (int)dh, null);
		}
		g.drawImage(img,
				(int)dx, (int)dy, (int)dw, (int)dh, null);
	}

	public BufferedImage getImage() {
		return _srcimg.getImage("down", _timing);
	}
}
