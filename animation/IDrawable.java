package animation;

import java.awt.Graphics;

public interface IDrawable {
	void draw(Graphics g);
	
	int[] pos();
	void pos(int x, int y);
}
