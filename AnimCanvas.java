import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

public class AnimCanvas extends Canvas implements Runnable {

	private int w, h;
	
	// start(1), stop(0)
	public int status = 0;
	
	// 位置、速度
	int x, y, y0;
	float vy, vy0=70;
	final float gravity = 9.8f;
	
	// 画像
	CharacterImage srcimg = null;
	int src_cursor;
	String[] direction = {"down", "left", "up", "right"};
	
	public AnimCanvas(int w, int h) {
		this.w = w;
		this.h = h;
		
		x = w / 2;
		y = y0 = h / 2;
		
		setBackground(Color.WHITE);
		
		srcimg = new CharacterImage("img/chara/pipo-charachip001.png");
		src_cursor = 0;
	}

	public AnimCanvas(GraphicsConfiguration config) {
		super(config);
	}
	

	public void paint(Graphics g) {
		String d = direction[(src_cursor/4) % 4];
		g.drawImage(srcimg.getImage(d, src_cursor%4), x - srcimg.w, y - srcimg.h, srcimg.w * 2, srcimg.h * 2, null);
	}
	
	public void update(Graphics g) {		
		if (status == 1) {
			src_cursor += 1;
			super.update(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			
			repaint();
		}
	}
}
