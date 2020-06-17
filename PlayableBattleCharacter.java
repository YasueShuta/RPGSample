import java.awt.Graphics;
import java.awt.event.KeyListener;

import animation.IMovable;
import animation.IPlayable;
import animation.MoveHandle;
import animation.PlayableHandle;

public class PlayableBattleCharacter extends BattleCharacter implements IMovable, IPlayable {

	protected MoveHandle _handle;
	protected boolean _playable;
	
	public PlayableBattleCharacter(String name, int age, String _class, String srcname, String shadowname, boolean playable) {
		this(name, age, _class, srcname, shadowname, 1, 100, 0, playable);
	}

	public PlayableBattleCharacter(String name, int age, String _class, String srcname, String shadowname, int level, int hp, int mp, boolean playable) {
		super(name, age, _class, level, hp, mp);
		_playable = playable;
		
		if (playable) {
			_handle = new PlayableHandle(srcname, shadowname);
		} else {
			_handle = new MoveHandle(srcname, shadowname);
		}
	}

	// オーバーライドは_handle経由で実装済み
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
}