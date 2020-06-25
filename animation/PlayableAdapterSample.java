package animation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

public class PlayableAdapterSample implements IMovable, IPlayable {

	protected MoveHandle _handle;
	protected boolean _playable;
	
	// プロパティの例
	protected String _name;
	
	public PlayableAdapterSample(String name) {
		this(name, CharaImageFile.YOUNG_MAN, ShadowImageFile.DEFAULT);
	}
	public PlayableAdapterSample(String name, String srcname, String shadowname) {
		this(name, srcname, shadowname, false);
	}
	public PlayableAdapterSample(String name, String srcname, String shadowname, boolean playable) {
		_name = name;
		
		initHandle(srcname, shadowname, playable);
	}

	// オーバーライドは_handle経由で実装済み
	private void initHandle(String srcname, String shadowname, boolean playable) {
		// IMovable, IPlayable適用のための初期化
		_playable = playable;
		
		if (playable) {
			_handle = new PlayableHandle(srcname, shadowname);
		} else {
			_handle = new MoveHandle(srcname, shadowname);
		}
	}
  
  @Override
	public void draw(Graphics g) {
		_handle.draw(g);
	}

	@Override
	public String direction() {
		return _handle.direction();
	}

	@Override
	public void direction(String d) {
		_handle.direction(d);
	}

	@Override
	public String state() {
		return _handle.state();
	}

	@Override
	public void state(String s) {
		_handle.state(s);
	}

	@Override
	public int[] pos() {
		return _handle.pos();
	}

	@Override
	public void pos(int x, int y) {
		_handle.pos(x, y);
	}

	@Override
	public double speed() {
		return _handle.speed();
	}

	@Override
	public void speed(double speed) {
		_handle.speed(speed);
	}

	@Override
	public double[] velocity() {
		return _handle.velocity();
	}

	@Override
	public void velocity(double vx, double vy) {
		_handle.velocity(vx, vy);
	}

	@Override
	public void down(int d) {
		_handle.down(d);
	}

	@Override
	public void left(int d) {
		_handle.left(d);
	}

	@Override
	public void up(int d) {
		_handle.up(d);
	}

	@Override
	public void right(int d) {
		_handle.right(d);
	}

	@Override
	public void stop() {
		_handle.stop();
	}

	@Override
	public void home() {
		_handle.home();
	}
	
	@Override
	public void home(int px, int py) {
		_handle.home(px, py);
	}

	@Override
	public void turnLeft() {
		_handle.turnLeft();
	}

	@Override
	public void turnRight() {
		_handle.turnRight();
	}

	@Override
	public void update() {
		_handle.update();
	}

	@Override
	public void countup() {
		_handle.turnLeft();
	}

	@Override
	public KeyListener getKeyListener() {
		PlayableHandle h = getPlayableHandle();
		if (h == null) return null;
		return h.getKeyListener();
	}

	@Override
	public void goDown(double v) {
		PlayableHandle h = getPlayableHandle();
		if (h != null) h.goDown(v);
	}

	@Override
	public void goLeft(double v) {
		PlayableHandle h = getPlayableHandle();
		if (h != null) h.goLeft(v);
	}

	@Override
	public void goUp(double v) {
		PlayableHandle h = getPlayableHandle();
		if (h != null) h.goUp(v);		
	}

	@Override
	public void goRight(double v) {
		PlayableHandle h = getPlayableHandle();
		if (h != null) h.goRight(v);
	}
	
	protected PlayableHandle getPlayableHandle() {
		if (_playable) {
			return (PlayableHandle)_handle;
		}
		return null;
	}

	// Characterに追加するメソッド
	@Override
	public double scale() {
		return _handle.scale();
	}
	@Override
	public void scale(double scale) {
		_handle.scale(scale);
	}
	@Override
	public Dimension size() {
		return _handle.size();
	}
	@Override
	public void size(int w, int h) {
		_handle.size(w, h);
	}
	@Override
	public boolean isVisible() {
		return _handle.isVisible();
	}
	@Override
	public void setVisible(boolean v) {
		_handle.setVisible(v);
	}
	@Override
	public void start() {
		_handle.start();
	}
	@Override
	public void start(int duration) {
		_handle.start(duration);	
	}
	@Override
	public boolean isRunning() {
		return _handle.isRunning();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		_handle.actionPerformed(e);
	}
	@Override
	public void turn(int duration, boolean clockwise) {
		_handle.turn(duration, clockwise);		
	}
	@Override
	public void move(int dx, int dy) {
		_handle.move(dx, dy);
	}
	@Override
	public void move(int dx, int dy, double speed) {
		_handle.move(dx, dy, speed);
	}
	@Override
	public void move(int dx, int dy, int duration) {
		_handle.move(dx, dy, duration);		
	}

	@Override
	public void wait(int duration) {
		_handle.wait(duration);
	}
	@Override
	public void randomWalk() {
		_handle.randomWalk();
	}
	@Override
	public void randomWalk(int d) {
		_handle.randomWalk(d);
	}
	@Override
	public void jump() {
		_handle.jump();
	}
	@Override
	public void forward(int d) {
		_handle.forward(d);
	}
	@Override
	public void back(int d) {
		_handle.back(d);
	}
}