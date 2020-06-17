package animation;

import java.awt.event.KeyListener;

public interface IPlayable extends IMovable {
	KeyListener getKeyListener();
	
	void goDown(double v);
	void goLeft(double v);
	void goUp(double v);
	void goRight(double v);
}
