import animation.*;
import java.util.*;

public class MyApp extends GachaSample {
    public MyApp() {
        super("YSHK");
    }

    @Override
    public void initHeroes() {
        IMovable m;
        
        Hero hime = Hero.create("Hime", 19, 1,
            /*is_male*/false, /*variation*/"e");
        // hime.home(w/2, h/2);
        hime.setRarity(3);
        hime.setPhrase("Watashi ga Hime yo!");
        setGachaHero(hime);

        Wizard taro = Wizard.create("Taro", 18, 1,
            /*is_male*/true, /*variation*/"");
        // taro.home(w/2, h/2);
        taro.setRarity(2);
        taro.setPhrase("%name% san, Konnichiha.");
        setGachaHero(taro);

        m = new MoveHandle(
            CharaImageFile.getFilename(CharaImageFile.CATb),
            ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
            w/2, h/2);
        setGachaHero(m);
    }

    public static void main(String[] args) {
        MyApp app = new MyApp();
        app.run();        
    }
}