package animation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayableHandle extends MoveHandle implements IPlayable, KeyListener {
	public PlayableHandle() {
	}
	public PlayableHandle(int x, int y) {
		super(x,y);
	}
	public PlayableHandle(String filename) {
		super(filename);
	}
	public PlayableHandle(String filename, int x, int y) {
		super(filename, x, y);
	}
	public PlayableHandle(String filename, String shadowname) {
		super(filename, shadowname);
	}
	public PlayableHandle(String filename, String shadowname, int x, int y) {
		super(filename, shadowname, x, y);
	}

	@Override
	public void goDown(double v) {
		_direction = 0;
		_state = 1;
		_vel[1] = v;
	}
	@Override
	public void goLeft(double v) {
		_direction = 1;
		_state = 1;
		_vel[0] = -v;
	}
	@Override
	public void goUp(double v) {
		_direction = 2;
		_state = 1;
		_vel[1] = -v;
	}
	@Override
	public void goRight(double v) {
		_direction = 3;
		_state = 1;
		_vel[0] = v;
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {		
		double v = 80;
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:				
			goUp(v);
			break;
		case KeyEvent.VK_DOWN:
			goDown(v);
			break;
		case KeyEvent.VK_RIGHT:
			goRight(v);
			break;
		case KeyEvent.VK_LEFT:
			goLeft(v);
			break;
		case KeyEvent.VK_SPACE:
			stop();
			break;
		case KeyEvent.VK_H:
			home();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		stop();
	}

}
