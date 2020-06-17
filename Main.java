import java.util.ArrayList;

import animation.AppBase;
import animation.BackgroundDrawer;
import animation.CharaImageFile;
import animation.MoveHandle;
import animation.ShadowImageFile;

class App extends AppBase {
	public App(String title) {
		super(800, 600, title);
	}
}

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
      MyCharacter c = (MyCharacter)i;
      Printer.println(c.name()+"のレベルは"+c.level());
    }

    hero.attack(satan);
    satan.attack(hero, 300);
  }
  
  static void demo() {
	  App app = new App("デモ");
	  
	  app.textWindow.setText("ボタンか矢印キーで移動可能");
	  
	  // Movableなキャラクターの表示
	  MoveHandle m = new MoveHandle(
			  CharaImageFile.DOG,
			  ShadowImageFile.ANIMAL);
	  m.home(600, 200);
	  m.direction("right");
	  app.addDrawable(m);
	  
	  // プレイヤーとしてHeroを作成
	  Hero p = new Hero("勇者", 15, true);
	  p.home(app.w/2, app.h/2);
	  app.addPlayable(p);

	  // NPCとしてHeroを作成
	  Hero npc = new Hero("戦士", 30, false);
	  npc.home(200, 200);
	  npc.direction("left");
	  app.addMovable(npc);

	  // 背景を設定
	  app.canvas.setBackground(BackgroundDrawer.FOREST);
	  
	  app.run();
  }

  public static void main(String[] args) {
	  //test();
	  //DemoWindow.main(args);
	  demo();
  }
}