import java.util.*;
import animation.*;

class Main {
    public static void main(String[] args) {
        DemoGacha app = new DemoGacha("Demo") {
            @Override
            public void initHeroes() {
                MoveHandle m;

                m = new MoveHandle(
                    CharaImageFile.getFilename(CharaImageFile.FIGHTER_FEMALEe),
                    ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
                    w/2, h/2);
                // Hero hime = new Hero("Hime", 19, 1, 100, 0,
                //     CharaImageFile.FIGHTER_FEMALEe, // srcname
                //     ShadowImageFile.DEFAULT);       // shadowname
                //hime.home(w/2, h/2);
                setGachaHero(m);

                m = new MoveHandle(
                    CharaImageFile.getFilename(CharaImageFile.WIZARD_MALE),
                    ShadowImageFile.getFilename(ShadowImageFile.DEFAULT),
                    w/2, h/2);
                // Wizard taro = new Wizard("Taro", 18, 1, 100, 150,
                //     CharaImageFile.WIZARD_MALE,     // srcname
                //     ShadowImageFile.DEFAULT);       // shadowname
                //taro.home(w/2, h/2);
                setGachaHero(m);

                m = new MoveHandle(
                    CharaImageFile.getFilename(CharaImageFile.CATb),
                    ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
                    w/2, h/2);
                setGachaHero(m);

                // taro.hello_to(hime);
            }
        };
        app.run();        
    }
}