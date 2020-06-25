package animation;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AnimCanvasBase extends Canvas implements Runnable {

	int w, h;
	
	// 画像
	ArrayList<IDrawable> images = new ArrayList<>();
	ArrayList<IMovable> objects = new ArrayList<>();
	IDrawable bgimage;

	public AnimCanvasBase(int w, int h) {
		this.w = w;
		this.h = h;
		setPreferredSize(new Dimension(w, h));
	}
	
	public void setBackground(String name) {
		BackgroundDrawer bd = new BackgroundDrawer(name);
		bd.size(w, h);
		bgimage = bd;
	}
	public void setBackground(IDrawable image) {
		bgimage = image;
		image.size(w, h);
	}
		
	public void paint(Graphics g) {
		if (bgimage != null) {
			bgimage.draw(g);			
		}
		for (IDrawable d : images) {
			if (d.isVisible()) d.draw(g);
		}
	}
	public void update(Graphics g) {
//		for (IMovable d : objects) {
//			d.update();
//		}
		super.update(g);
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			
			repaint();
		}
	}
}
