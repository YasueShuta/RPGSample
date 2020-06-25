import java.util.*;
import animation.*;

class Main {
  static void enshu11_1() {
 		// ウィンドウの作成
		DemoWindow app = new DemoWindow("Demo");

		// 描画可能なキャラクターの作成
    Hero hime = Hero.create("Hime", 15, 1, false, "e", true);
    hime.home(400, 300);
		app.addPlayable(hime);

    Wizard taro = Wizard.create("Taro", 18, 1, true, "");
    taro.home(600, 200);
    //taro.direction("left");
    taro.left(400);
		app.addDrawable(taro);

		// 背景を設定
		app.canvas.setBackground(BackgroundDrawer.GRASS);
		
    app.run();    
  }
  static void enshu11_2(String[] args) {
    DemoGacha.main(args);
  }
  static void enshu11_3() {
    DemoGacha app = new DemoGacha("Demo") {
      @Override
      public void initHeroes() {
    		MoveHandle m;
     		m = new MoveHandle(
				  CharaImageFile.getFilename(CharaImageFile.KING),
				  ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				  w/2, h/2);
		    setGachaHero(m);

    		m = new MoveHandle(
		  		CharaImageFile.getFilename(CharaImageFile.PRIEST_FEMALEa),
			  	ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				  w/2, h/2);
		    setGachaHero(m);

    		m = new MoveHandle(
		  		CharaImageFile.getFilename(CharaImageFile.BOSS),
			  	ShadowImageFile.getFilename(ShadowImageFile.LARGE),
				  w/2, h/2);
		    setGachaHero(m);
      }
    };
    app.run();
  }

  static void enshu11_3a() {
    // 確率を考慮
    DemoGacha app = new DemoGacha("Demo") {
      ArrayList<Double> _probs = new ArrayList<>();
      double _totalProb = 0.0;

      @Override
      public void initHeroes() {
    		MoveHandle m;
     		m = new MoveHandle(
				  CharaImageFile.getFilename(CharaImageFile.KING),
				  ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				  w/2, h/2);
		    setGachaHero(m, 1);

    		m = new MoveHandle(
		  		CharaImageFile.getFilename(CharaImageFile.PRIEST_FEMALEa),
			  	ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
				  w/2, h/2);
		    setGachaHero(m, 2);

    		m = new MoveHandle(
		  		CharaImageFile.getFilename(CharaImageFile.CATb),
			  	ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
				  w/2, h/2);
		    setGachaHero(m, 3);
      }

      public void setGachaHero(MoveHandle m, double p) {
        setGachaHero(m);
        _probs.add(p);
        _totalProb += p;
      }

      public void choice() {
        double d = rd.nextDouble(); // 0.0~1.0
        d *= _totalProb;            // 0.0~_totalProb

        double sum = 0.0;
        for(int i=0; i<heroes.size(); i++) {
          sum += _probs.get(i);
          if (sum >= d) {
            cast = heroes.get(i);
            break;
          }
        }

        if (cast == null) return;
     		cast.direction("right");
        cast.setVisible(true);
      }
    };
    app.run();
  }
  public static void main(String[] args) {
    enshu11_3();
  }
}