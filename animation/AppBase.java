package animation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AppBase extends JFrame implements Runnable {

	public int w;
	public int h;
	int focus = 0;
	int _state = 0;

	public AnimCanvasBase canvas = null;
	public CommandWindow commandWindow;
	public TextWindow textWindow;
	
	IPlayable player = null;
	
	public AppBase() throws HeadlessException {
		this(800, 600);
	}
	public AppBase(int w, int h) {
		init(w, h);
	}

	public AppBase(int w, int h, GraphicsConfiguration gc) {
		super(gc);
		init(w, h);
	}

	public AppBase(int w, int h, String title) throws HeadlessException {
		super(title);
		init(w, h);
	}

	public AppBase(int w, int h, String title, GraphicsConfiguration gc) {
		super(title, gc);
		init(w, h);
	}
	
	public void setCanvas(AnimCanvasBase canvas) {
		this.canvas = canvas;
		init();
	}

	private void init() {
		init(w, h);
	}
	private void init(int w, int h) {
		this.w = w;
		this.h = h;
		
		// ウィンドウを閉じたらプログラムを終了する
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ウィンドウのサイズ,初期位置
		setSize(w, h);
		setLocationRelativeTo(null);
		
		// AnimCanvasのインスタンスを生成
		if (canvas == null) {
			canvas = new AnimCanvas(w, h - 100);
		}
		
		// TextWindowのインスタンスを生成
		textWindow = new TextWindow(w - 380, 0, 18);
		int sub_h = textWindow.getSize().height;
		
		// CommandWindowのインスタンスを生成
		commandWindow = new CommandWindow(180, sub_h, 14);
		
		// CrossButtonPanelのインスタンスを生成
		CrossButtonPanel p_btn = new CrossButtonPanel(this);
		
		// フレームの追加
		JPanel p_main = new JPanel();
		JPanel p_sub = new JPanel();
		
		// フレームの配置
		Container cp = getContentPane();
		cp.removeAll();
		
		cp.add(p_main, BorderLayout.CENTER);
		cp.add(p_sub, BorderLayout.SOUTH);

		p_main.add(canvas, BorderLayout.CENTER);
		p_sub.add(textWindow);
		p_sub.add(commandWindow);
		p_sub.add(p_btn);
		
		// ウィンドウを表示
		setVisible(true);
		
	}
	
	@Override
	public void run() {
		// アニメーションを開始
		new Thread(canvas).start();
	}
	
	public void addDrawable(IDrawable ... args) {
		for (IDrawable obj : args) {
			canvas.images.add(obj);
		}
	}
	public void addMovable(IMovable ... args) {
		for (IMovable obj : args) {
			canvas.images.add(obj);
			canvas.objects.add(obj);
		}
	}
	public void addPlayable(IPlayable player) {
		canvas.images.add(player);
		canvas.objects.add(player);
		this.player = player;
		
		//addKeyListener(player.getKeyListener());
		canvas.addKeyListener(player.getKeyListener());
	}

	
	public void onButtonPressed(ActionEvent e) {
		String cmd = e.getActionCommand();		
		//System.out.println("@AppBase: " + cmd);
		
		if (focus == 0) {
			if (cmd == ButtonCommand.ENTER) {
				_state = 1;
			}
			for (KeyListener lsnr : canvas.getKeyListeners()) {
				if (cmd != ButtonCommand.CANCEL) {
					lsnr.keyPressed(button2KeyEvent(e, ButtonCommand.CANCEL));
				}
				lsnr.keyPressed(button2KeyEvent(e));
			}
		} else if (focus == 1){
			if (cmd == ButtonCommand.ENTER) {
				_state = 2;
			} else if (cmd == ButtonCommand.CANCEL) {
				_state = 3;
				closeCommand();
			} else if (cmd == ButtonCommand.UP) {
				commandWindow.moveCursor(-1);
			} else if (cmd == ButtonCommand.DOWN) {
				commandWindow.moveCursor(1);
			}
		}
	}
	
	KeyEvent button2KeyEvent(ActionEvent e) {
		return button2KeyEvent(e, e.getActionCommand());
	}
	KeyEvent button2KeyEvent(ActionEvent e, String cmd) {
		int code;
		char c;
		if (cmd == ButtonCommand.UP) {
			code = KeyEvent.VK_UP;
			c = 0;
		} else if (cmd == ButtonCommand.LEFT) {
			code = KeyEvent.VK_LEFT;
			c = 0;
		} else if (cmd == ButtonCommand.RIGHT) {			
			code = KeyEvent.VK_RIGHT;
			c = 0;
		} else if (cmd == ButtonCommand.DOWN) {
			code = KeyEvent.VK_DOWN;
			c = 0;
		} else if (cmd == ButtonCommand.ENTER) {
			code = KeyEvent.VK_H;
			c = 'H';
		} else if (cmd == ButtonCommand.CANCEL) {
			code = KeyEvent.VK_SPACE;
			c = ' ';
		} else {
			return null;
		}
 		return new KeyEvent(
				(Component) e.getSource(),
				e.getID(),
				e.getWhen(),
				e.getModifiers(),
				code, c);
	}

	
	public void askCommand(String text, String[] options) {
		textWindow.setText(text);
		openCommand(options);
	}
	
	public void openCommand() {
		commandWindow.setVisible(true);
		focus = 1;
	}
	public void openCommand(String ... items) {
		commandWindow.setList(items);
		openCommand();
	}
	public void setCommand(String ... items) {
		commandWindow.setList(items);
	}
	public void closeCommand() {
		commandWindow.setVisible(false);
		focus = 0;
	}
	public int getSelectedCommand() {
		return commandWindow.getSelectedIndex();
	}
	public void setFocus(int f) {
		focus = f;
	}

}
