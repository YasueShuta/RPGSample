package animation;

public class DemoWindow extends AppBase {
	
	public DemoWindow(String title) {
		super(800, 600, title);
		
		// TextWindowの初期文字列
		textWindow.setText("O: Ask a question.");
	}

	public static void main(String[] args) {
		// ウィンドウの作成
		DemoWindow app = new DemoWindow("Demo");

		// 移動可能なキャラクターの作成
		MoveHandle m = new MoveHandle(
				CharaImageFile.YOUNG_WOMAN,
				ShadowImageFile.DEFAULT,
				app.w/3, app.h/3);
		m.direction("right");
		app.addMovable(m);
		
		// プレイヤーとして操作可能なキャラクターの作成
		PlayableHandle p = new PlayableHandle(
				CharaImageFile.YOUNG_MAN,
				ShadowImageFile.DEFAULT,
				app.w/2, app.h/2);
		app.addPlayable(p);
		
		// 背景を設定
		app.canvas.setBackground(BackgroundDrawer.CAVE);
		
		app.run();
	}
	
	@Override
	public void run() {
		super.run();
		
		while (true) {
			try {
				Thread.sleep(200);
				switch (_state) {
				case 0:
					// Wait
					break;
				case 1:
					// Ask -> Wait
					String askMsg = "Please, help!\nNa? Na?";
					String[] items = {"No", "No", "Yes"};
					askCommand(askMsg, items);	
					_state = 0;
					break;
				case 2:
					// Enter -> Wait
					System.out.println(commandWindow.getSelectedValue());
					closeCommand();
				case 3:
					// Canceled -> Wait
					textWindow.setText("O: Ask a question.");
					_state = 0;
					break;
				default:
					break;
				}
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}
