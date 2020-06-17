import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Main {
 	static int w = 800, h = 600;

	public static void run() {
		// JFrameのインスタンスを生成
		JFrame frame = new JFrame("アニメーション");
		// ウィンドウを閉じたらプログラムを終了する
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ウィンドウのサイズ,初期位置
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		
		// AnimCanvasのインスタンスを生成
		AnimCanvas canvas = new AnimCanvas(w, h);
		
		// フレームの追加
		JPanel p_main = new JPanel();
		frame.getContentPane().add(p_main, BorderLayout.CENTER);
		JPanel p_ctrl = new JPanel();
		frame.getContentPane().add(p_ctrl, BorderLayout.SOUTH);
		
		canvas.setPreferredSize(new Dimension(w, h));
		p_main.add(canvas);
		
		// スタートボタン
		JButton b_start = new JButton("START");
		b_start.addActionListener(ButtonListener.starter(canvas));
		p_ctrl.add(b_start);
		
		// ストップボタン
		JButton b_stop = new JButton("STOP");
		b_stop.addActionListener(ButtonListener.stopper(canvas));
		p_ctrl.add(b_stop);
		
		// ウィンドウを表示
		frame.setVisible(true);
		
		// アニメーションを開始
		new Thread(canvas).start();
	}

  static void test() {
    ArrayList<IBattlable> b = new ArrayList<>();

    BattleCharacter hero = new BattleCharacter("勇者", 15, "Hero", 1, 100, 100);
    BattleCharacter satan = new BattleCharacter("魔王", 300, "Satan", 100, 300, 5000);
    b.add(hero);
    b.add(satan);

    BattleCharacter tmp = (BattleCharacter)b.get(0);
    tmp.levelup(49);

    for (IBattlable i : b) {
      Character c = (Character)i;
      Printer.println(c.name()+"のレベルは"+c.level());
    }

    hero.attack(satan);
    satan.attack(hero, 300);
  }
  public static void main(String[] args) {
    test();
    run();
  }
}