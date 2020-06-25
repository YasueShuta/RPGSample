import java.util.*;
import animation.*;

class Main {
  public static void main(String[] args) {
 		// ウィンドウの作成
		DemoWindow app = new DemoWindow("Demo");

		// 描画可能なキャラクターの作成
    //BattleCharacter hero = new BattleCharacter("勇者", 15, "Hero", 1, 100, 100, CharaImageFile.FIGHTER_MALE, ShadowImageFile.DEFAULT, true);
    Hero hime = Hero.create("Hime", 15, 1, false, "e", true);
    hime.home(400, 300);
		app.addPlayable(hime);

    Wizard taro = Wizard.create("Taro", 18, 1, true, "");
    taro.home(600, 200);
    taro.direction("left");
		app.addDrawable(taro);

		// 背景を設定
		app.canvas.setBackground(BackgroundDrawer.GRASS);
		
    app.run();
  }
}