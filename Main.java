import java.util.*;
import animation.*;

class Main {
    public static void main(String[] args) {
        Person player = new Person("AAAA", 20);

        DemoGacha app = new DemoGacha("Demo") {
            @Override
            public void initHeroes() {
                IMovable m;
                
                Hero hime = new Hero("Hime", 19, 1, 100, 0,
                    CharaImageFile.FIGHTER_FEMALEe, // srcname
                    ShadowImageFile.DEFAULT);       // shadowname
                hime.home(w/2, h/2);
                setGachaHero(hime);

                Wizard taro = new Wizard("Taro", 18, 1, 100, 150,
                    CharaImageFile.WIZARD_MALE,     // srcname
                    ShadowImageFile.DEFAULT);       // shadowname
                taro.home(w/2, h/2);
                setGachaHero(taro);

                m = new MoveHandle(
                    CharaImageFile.getFilename(CharaImageFile.CATb),
                    ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
                    w/2, h/2);
                setGachaHero(m);

                taro.hello_to(hime);
            }

            @Override
            public void choice() {
                super.choice();
                Printer.clear();
                Printer.println("Success!");
                if (cast instanceof Person) {
                    ((Person)cast).hello(player);
                }
            }
        };
        Printer.setTextWindow(app.textWindow);
        Printer.clear();
        Printer.println("Hello!\nLet's Gacha!");
        app.run();        
    }
}