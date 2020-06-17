package animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MoveHandle extends DrawableCharacterHandle implements IMovable {

	protected int _px,_py;
	protected double[] _vel  = {0.0, 0.0};
	protected double _fps = 5;
	
	public MoveHandle() {
		this(0,0);
	}
	public MoveHandle(int x, int y) {
		this(CharaImageFile.YOUNG_MAN, x, y);
	}
	public MoveHandle(String filename) {
		this(filename, 0, 0);
	}
	public MoveHandle(String filename, int x, int y) {
		this(filename, CharaImageFile.YOUNG_MAN, x, y);
	}
	public MoveHandle(String filename, String shadowname) {
		this(filename, shadowname, 0, 0);
	}
	public MoveHandle(String filename, String shadowname, int x, int y) {
		super(filename, shadowname);
		_px = x;
		_py = y;
		home();
	}

	@Override
	public String direction() {
		return IMovable.DIRECTIONS[_direction];
	}
	@Override
	public void direction(String d) {
		if (d == IMovable.DIRECTIONS[0]) {
			_direction = 0;
		} else if (d == IMovable.DIRECTIONS[1]) {
			_direction = 1;
		} else if (d == IMovable.DIRECTIONS[2]) {
			_direction = 2;
		} else if (d == IMovable.DIRECTIONS[3]) {
			_direction = 3;
		}
	}

	@Override
	public String state() {
		return IMovable.STATES[_state];
	}
	@Override
	public void state(String s) {
		if (s == IMovable.STATES[0]) {
			_state = 0;
		} else if (s == IMovable.STATES[1]) {
			_state = 1;
		}
	}

	@Override
	public BufferedImage getImage() {
		return _srcimg.getImage(direction(), _timing);
	}

	@Override
	public double speed() {
		return Math.sqrt(_vel[0]*_vel[0] + _vel[1]*_vel[1]);
	}

	@Override
	public void speed(double speed) {
		if (speed == 0) {
			stop();
			return;
		}
		double curspeed = speed();
		if (curspeed != speed) return;
		if (curspeed == 0) {
			// 0:down 1:left 2:up 3:right
			if (_direction == 0) {
				_vel[1] = speed;
			} else if (_direction == 1) {
				_vel[0] = speed;
			} else if (_direction == 2) {
				_vel[1] = - speed;
			} else if (_direction == 3) {
				_vel[0] = - speed;
			}
			return;
		}
		_vel[0] *= speed / curspeed;
		_vel[1] *= speed / curspeed;
	}

	@Override
	public double[] velocity() {
		return _vel;
	}

	@Override
	public void velocity(double vx, double vy) {
		_vel[0] = vx;
		_vel[1] = vy;
	}

	@Override
	public void down(int d) {
		_direction = 0;
		_pos[1] += d;
	}
	@Override
	public void left(int d) {
		_direction = 1;
		_pos[0] -= d;
	}

	@Override
	public void up(int d) {
		_direction = 2;
		_pos[1] -= d;
	}

	@Override
	public void right(int d) {
		_direction = 3;
		_pos[0] += d;
	}
	
	@Override
	public void stop() {
		_timing = 0;
		_vel[0] = 0.0;
		_vel[1] = 0.0;
		_state = 0;
	}

	@Override
	public void home() {
		_pos[0] = _px;
		_pos[1] = _py;
	}
	
	@Override
	public void home(int px, int py) {
		_px = px;
		_py = py;
		pos(_px, _py);
	}

	
	@Override
	public void turnLeft() {
		double tmp = _vel[0];
		_vel[0] = - _vel[1];
		_vel[1] = tmp;
		
		_direction = (_direction - 1) % 4;
	}
	@Override
	public void turnRight() {
		double tmp = -_vel[0];
		_vel[0] = _vel[1];
		_vel[1] = tmp;

		_direction = (_direction + 1) % 4;
	}

	
	@Override
	public void draw(Graphics g) {
		int t;
		if (_state == 0) {
			t = 0;
		} else {
			countup();
			t = _timing % 4;
		}
		int w = _srcimg.w;
		int h = _srcimg.h;
		
		g.drawImage(_shadow.getImage(direction(), t),
				_pos[0] - w, (int)(_pos[1] - 0.85*h), w * 2, h * 2, null);
		g.drawImage(_srcimg.getImage(direction(), t),
				_pos[0] - w, _pos[1] - h, w * 2, h * 2, null);

	}

	@Override
	public void update() {
		double dt = 1 / _fps;
		_pos[0] += _vel[0] * dt;
		_pos[1] += _vel[1] * dt;		
	}
	@Override
	public void countup() {
		_timing ++;
	}
}
