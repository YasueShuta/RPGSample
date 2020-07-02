package animation;

import java.awt.event.ActionListener;

public interface IAnimation extends IDrawable, ActionListener {
	void start();
	void start(int duration);
	void stop();
	boolean isRunning();
	void countup();
}
