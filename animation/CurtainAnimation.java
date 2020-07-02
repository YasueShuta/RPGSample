package animation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class CurtainAnimation
	implements IAnimation
{
	int _w, _h;
	AnimHandle _openingCurtain;
	AnimHandle _closingCurtain;
	private int _state = 0;
	
	public CurtainAnimation() {
		this(640, 480);
	}
	public CurtainAnimation(int w, int h) {
		_openingCurtain = new AnimHandle(w, h,
				GachaImageFile.getFilename(GachaImageFile.CURTAIN_OPEN));
		_closingCurtain = new AnimHandle(w, h,
				GachaImageFile.getFilename(GachaImageFile.CURTAIN_CLOSE));

		_openingCurtain.setVisible(false);
	}
	
	public void setTimer(int delay) {
		setTimer(delay, delay);
	}
	public void setTimer(int delay_open, int delay_close) {
		_openingCurtain.setTimer(delay_open, this);
		_closingCurtain.setTimer(delay_close, this);
	}
	
	public void addToApp(AppBase app) {
		app.addDrawable(_openingCurtain);
		app.addDrawable(_closingCurtain);
	}
	
	static String[] STATE = {"close", "opening", "open", "closing"};
	public String state() {
		return STATE[_state];
	}
	public void state(String s) {
		int i=0;
		for (String _s : STATE) {
			if (s == _s) {
				_state = i;
			}
			i++;
		}
		
		switch(_state) {
		case 0:
		case 1:
			setVisible(true, false);
			_openingCurtain._srcimg._cursor = 0;
			break;
		case 2:
			setVisible(false, false);
			break;
		case 3:
			setVisible(false, true);
			_closingCurtain._srcimg._cursor = 0;
			break;
		default:
			break;
		}
	}

	public void start(boolean is_opening, int duration) {
		int ny;
		if (is_opening) {
			ny = _openingCurtain._srcimg._ny;
			_openingCurtain.setTimer(duration / ny);
		} else {
			ny = _closingCurtain._srcimg._ny;
			_closingCurtain.setTimer(duration / ny);
		}
		start(is_opening);
	}
	
	public void start(boolean is_opening) {
		if (is_opening) {
			state("opening");
			_openingCurtain.start();
		} else {
			state("closing");
			_closingCurtain.start();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		if(_openingCurtain.isVisible()) _openingCurtain.draw(g);
		if(_closingCurtain.isVisible()) _closingCurtain.draw(g);
	}
	@Override
	public boolean isVisible() {
		return _openingCurtain.isVisible() || _closingCurtain.isVisible();
	}
	@Override
	public void setVisible(boolean v) {
		setVisible(v, v);
	}
	public void setVisible(boolean open, boolean close) {
		_openingCurtain.setVisible(open);
		_closingCurtain.setVisible(close);
	}
	@Override
	public int[] pos() {
		return 	_openingCurtain.pos();
	}
	@Override
	public void pos(int x, int y) {
		_openingCurtain.pos(x, y);
		_closingCurtain.pos(x, y);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(_openingCurtain.isVisible()) _openingCurtain.actionPerformed(e);
		if(_closingCurtain.isVisible()) _closingCurtain.actionPerformed(e);
		if (!isRunning()) {
			if(_openingCurtain.isVisible() && _state == 1) {
				state("open");
			}
			if(_closingCurtain.isVisible() && _state == 3) {
				state("close");
			}
		}
	}
	@Override
	public void start() {
		start(true);
	}
	@Override
	public void start(int duration) {
		start(true, duration);
	}
	@Override
	public void stop() {
		if(_openingCurtain.isVisible()) {
			_openingCurtain.stop();
			state("open");
		}
		if(_closingCurtain.isVisible()) {
			_closingCurtain.stop();
			state("close");
		}
	}
	@Override
	public boolean isRunning() {
		boolean ret = _openingCurtain.isRunning() || _closingCurtain.isRunning();
		return ret;
	}
	@Override
	public void countup() {
		if(_openingCurtain.isVisible()) _openingCurtain.countup();
		if(_closingCurtain.isVisible()) _closingCurtain.countup();
	}
	@Override
	public double scale() {
		return _openingCurtain.scale();
	}
	@Override
	public void scale(double scale) {
		_openingCurtain.scale(scale);
		_closingCurtain.scale(scale);		
	}
	@Override
	public Dimension size() {
		return _openingCurtain.size();
	}
	@Override
	public void size(int w, int h) {
		_openingCurtain.size(w, h);
		_closingCurtain.size(w, h);
	}
}
