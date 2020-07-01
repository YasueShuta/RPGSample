package animation;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MoveHandle extends AnimHandle implements IMovable {
	static Random rd;

	protected AnimSourceImage _shadow;
	protected int _px,_py;
	protected int _z = 0;
	protected double _dz = 0d;
	protected int _shadow_y;
	protected double[] _vel  = {0.0, 0.0};
	
	protected int _direction = 0;
	protected int _state = 0;
	protected int _timing = 0;
	protected String _animation_mode = "walking";
	
	private static int[] _timingToX = {1, 0, 1, 2};
	private static int[] _directionToY = {0, 1, 3, 2};	
	
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
		this(filename, shadowname, 3, 4, x, y);
	}
	public MoveHandle(String filename, String shadowname, int nx, int ny, int x, int y) {
		super(filename);
    _srcimg.setAnimSource(nx, ny);
		_shadow = new AnimSourceImage(shadowname);
    _shadow.setAnimSource(nx, ny);

		_px = x;
		_py = y;
		_shadow_y = (int) (0.075 * _srcimg.h);
		scale(2d);
		setTimer(200);
		home();
	}

	@Override
	public String direction() {
		return DIRECTIONS[_direction];
	}
	@Override
	public void direction(String d) {
		int i = 0;
		for (String s : DIRECTIONS) {
			if (s == d) {
				_direction = i;
				return;
			}
			i++;
		}
	}

	@Override
	public String state() {
		return STATES[_state];
	}
	@Override
	public void state(String s) {
		int i = 0;
		for (String t : STATES) {
			if (t == s) {
				_state = i;
			}
			i++;
		}
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
			// 0:down(+y) 1:left(-x) 2:up(-y) 3:right(+x)
			int i = _direction % 2 == 0 ? 1 : 0;
			int sign = (_direction-1)/2 == 0 ? 1 : -1;
			_vel[i] = sign * speed;
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
	public void move(int dx, int dy) {
		move(dx, dy, 50d);
	}
	@Override
	public void move(int dx, int dy, double speed) {
		double ds = Math.sqrt(dx*dx + dy*dy);
		move(dx, dy, (int)(1000 * ds / speed));
	}
	@Override
	public void move(int dx, int dy, int duration) {
		_animation_mode = "walking";
		_state = 1;
		double dt = duration / 1000d;
		velocity(dx/dt, dy/dt);
		start(duration);
	}

	@Override
	public void down(int d) {
		_direction = 0;
		move(0, d);
	}
	@Override
	public void left(int d) {
		_direction = 1;
		move(-d, 0);
	}
	@Override
	public void up(int d) {
		_direction = 2;
		move(0, -d);
	}
	@Override
	public void right(int d) {
		_direction = 3;
		move(d, 0);
	}
	@Override
	public void wait(int duration) {
		_state = 0;
		start(duration);
	}
	@Override
	public void stop() {	
		_vel[0] = 0.0;
		_vel[1] = 0.0;
		_state = 0;		

		if (_timer != null && _timer.isRunning()) {
			_stopTime = -1;
			_timer.stop();
		}
	}

	@Override
	public void randomWalk() {
		randomWalk(50);
	}
	@Override
	public void randomWalk(int d) {
		if (rd == null) rd = new Random();
		
		int r = rd.nextInt(8);

		switch(r) {
		case 0:
			down(d);
			break;
		case 1:
			left(d);
			break;
		case 2:
			up(d);
			break;
		case 3:
			right(d);
			break;
		default:
			wait(1000);
			break;
		}
	}
	@Override
	public void jump() {
		_animation_mode = "jumping";
		_dz = _srcimg.h * -1.5;
		start();
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
	public void forward(int d) {
		switch(_direction) {
		case 0: // down
			down(d);
			break;
		case 1: // left
			left(d);
			break;
		case 2: // up
			up(d);
			break;
		case 3: // right
			right(d);
			break;
		default:
			break;
		}
	}
	@Override
	public void back(int d) {
		forward(-d);
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
	public void turn(int duration, boolean clockwise) {
		_state = 1; // walk
		_animation_mode = "walking";
		if (clockwise) {
			turnRight();
		} else {
			turnLeft();
		}
		start(duration);
	}

	@Override
	public void draw(Graphics g) {
		int x;
		switch (_state) {
		case 1:
			// walk
			x = _timingToX[_timing % 4];
			break;
		case 0:
			// idle
		default:
			x = _timingToX[0];
			break;
		}
		int y = _directionToY[_direction];
		
		int w = (int)(_srcimg.w * _scale);
		int h = (int)(_srcimg.h * _scale);
		int sy = (int)(_shadow_y * _scale);
		
		g.drawImage(_shadow.getImage(x, y),
				_pos[0] - w/2, _pos[1] - h/2 + sy, w, h, null);
		g.drawImage(_srcimg.getImage(x, y),
				_pos[0] - w/2, _pos[1] - h/2 + _z, w, h, null);
	}
	
	@Override
	public void start(int duration) {
		long currTime = System.currentTimeMillis();
		_stopTime = currTime + duration;		
		_timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		update();

		if (_animation_mode == "walking") {
		} else if (_animation_mode == "jumping") {
			_z += (int) (_dz * _delay / 1000d * _scale);
			if (_z > 0) {
				_z = 0;
				_dz = 0d;
				stop();
				_animation_mode = "walking";
			} else {
				_dz += _srcimg.h;
			}
		}
	}

	@Override
	public void update() {
		double dt = _delay / 1000d;
		_pos[0] += _vel[0] * dt;
		_pos[1] += _vel[1] * dt;		
	}

	@Override
	public void countup() {
		_timing++;
	}	
}
