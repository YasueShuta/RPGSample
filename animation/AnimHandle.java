package animation;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

public class AnimHandle
	extends DrawableHandle
	implements IAnimation
{
	protected AnimSourceImage _srcimg;
	protected int _delay = 10;
	
	protected Timer _timer;
	protected long _stopTime = -1;
	
	public AnimHandle(String filename) {
		_srcimg = new AnimSourceImage(filename);
	}
	public AnimHandle(int w, int h, String filename) {
		_srcimg = new AnimSourceImage(w, h, filename);
	}
	
	public void setTimer(int delay) {
		setTimer(delay, this);
	}
	public void setTimer(int delay, ActionListener lsnr) {
		_delay = delay;
		_timer = new Timer(delay, lsnr);
	}

	@Override
	public void start() {
		_srcimg._cursor = 0;
		_timer.start();
	}
	
	@Override
	public void start(int duration) {
		long currTime = System.currentTimeMillis();
		_stopTime = currTime + duration;
		start();
	}

	@Override
	public void stop() {
		_timer.stop();
		_stopTime = -1;
	}
	
	@Override
	public boolean isRunning() {
		return _timer.isRunning();
	}
		
	@Override
	public void countup() {
		_srcimg._cursor++;
		if (_srcimg._cursor >= _srcimg._nx * _srcimg._ny) {
			_srcimg._cursor--;
			stop();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (_stopTime > 0) {
			long currTime = System.currentTimeMillis();
			if (_stopTime <= currTime) {
				stop();
				return;
			}
		}
		
		countup();
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
}
