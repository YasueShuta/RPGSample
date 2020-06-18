/* Person.java: (演習9-2)登場人物クラス
 * Interface:
   IPrintable:(継承)会話文を出力
   ITalkable: (継承)会話可能
 * Parent:
   Person
 * Childs:
   BattleCharacter: 戦闘可能な登場人物 */
import animation.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Character
    extends Person
    implements IMovable, IPlayable
{
  /* プロパティ */
  public String _class;
  public int _level;

	protected MoveHandle _handle;
	protected boolean _playable;

  /* コンストラクタ */
  public Character(String name, int age, String _class, int level) {
    this(name, age, _class, level, "001", "001");
  }
  public Character(String name, int age, String _class, int level, String srcname, String shadowname) {
    this(name, age, _class, level, srcname, shadowname, false);
  }
 	public Character(String name, int age, String _class, int level, String srcname, String shadowname, boolean playable) {
    super(name, age);
    this._class = _class;
    _level = level;

    initHandle(srcname, shadowname, playable);
	}

 
  /* 公開メソッド */
  public String _class() {
    return _class;
  }
  public int level() {
    return _level;
  }
  public void levelup() {
    levelup(1);
  }
  public void levelup(int level) {
    Printer.print(_name + "のレベルが");
    Printer.println(level + "上がった.");
    _level += level;
  }
	
	// ここからPlayableAdapterSampleのメソッドのコピー
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
}
