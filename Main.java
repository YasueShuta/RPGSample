import java.util.*;
/* enshu10-1: TODO */
import animation.*;

class Main {
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
  static void enshu10_1(String[] args) {
    DemoWindow.main(args);
  }
  static void enshu10_2() {
 		// ウィンドウの作成
		DemoWindow app = new DemoWindow("Demo");

		// 描画可能なキャラクターの作成
    BattleCharacter hero = new BattleCharacter("勇者", 15, "Hero", 1, 100, 100);
    hero.pos(400, 300);
		app.addDrawable(hero);
		
		// 背景を設定
		app.canvas.setBackground(BackgroundDrawer.GRASS);
		
		app.run();
  }
  static void enshu10_3() {
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
  public static void main(String[] args) {
    //test();
    /* enshu10: TODO */
    // enshu10_1(args);
    //enshu10_2();
    enshu10_3();
  }
}