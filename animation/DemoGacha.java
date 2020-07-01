package animation;

import java.util.ArrayList;
import java.util.Random;

public class DemoGacha extends AppBase {
	protected CurtainAnimation curtain;
	protected IMovable cast;
	protected ArrayList<IMovable> heroes = new ArrayList<>();
	protected Random rd = new Random();
	
	public DemoGacha(String title) {
		super(640, 580, title);
		
		// TextWindowの初期文字列
		textWindow.setText("O: Gacha!");
	}

	public static void main(String[] args) {
		// ウィンドウの作成
		DemoGacha app = new DemoGacha("Demo");
    app.run();
	}
	
	@Override
	public void run() {
		// 移動可能なキャラクターの作成
		initHeroes();

		// 前景アニメーション
		curtain = new CurtainAnimation();
		curtain.pos(w/2, h/3);
		curtain.setTimer(200, 50);
		curtain.addToApp(this);
		curtain.state("close");
		
		// 背景
		canvas.setBackground(BackgroundDrawer.CASTLE);

		super.run();
		
		while (true) {
			try {
				Thread.sleep(200);

				switch(_state) {
				case 0:
					// 入力待ち受け状態
					// 真ん中ボタンを押すと_state = 1
					if (curtain.state() == "open") {
						curtainClose();
					}
					break;
				case 1:
					// ガチャを引く
					if (curtain.state() == "open") {
						curtainClose();
					} else if(curtain.state() == "close") {
						choice();
						curtainOpen();
						_state = 2;
					}
				case 2:
					castDance();
					break;
				default:
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void initHeroes() {
		MoveHandle m;
		m = new MoveHandle(
				CharaImageFile.getFilename(CharaImageFile.FIGHTER_MALE),
				ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				w/2, h/2);
		setGachaHero(m);

		m = new MoveHandle(
				CharaImageFile.getFilename(CharaImageFile.WIZARD_FEMALEa),
				ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				w/2, h/2);
		setGachaHero(m);

		m = new MoveHandle(
				CharaImageFile.getFilename(CharaImageFile.DOGb),
				ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
				w/2, h/2);
		setGachaHero(m);
	}

	public void setGachaHero(IMovable m) {
		m.setVisible(false);
		m.scale(5d);
		m.setTimer(200);

		addDrawable(m);
		heroes.add(m);
	}
	
	public void choice() {
		int i = rd.nextInt(heroes.size());
		cast = heroes.get(i);
		cast.direction("right");
		cast.setVisible(true);
	}
	public void curtainOpen() {
		curtain.start(true);
	}
	public void curtainClose() {
		if (cast != null) {
			cast.setVisible(false);
			cast = null;
		}
		curtain.start(false);
	}

	private int cast_state = 0;
	public void castDance() {
		if (cast != null && !cast.isRunning()) {
			switch(cast_state) {
			case 0:
				cast.jump();
				cast_state = 1;
				break;
			case 1:
				cast.turn(1000, true);
				cast_state = 0;
				break;
			}
		}
	}
}