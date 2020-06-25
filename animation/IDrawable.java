package animation;

import java.awt.Dimension;
import java.awt.Graphics;

public interface IDrawable {
	void draw(Graphics g);
	boolean isVisible();
	void setVisible(boolean v);

	double scale();
	void scale(double scale);
	
	Dimension size();
	void size(int w, int h);
	
	int[] pos();
	void pos(int x, int y);
}
