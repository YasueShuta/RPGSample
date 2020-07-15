import animation.*;
import java.util.*;

public class MyApp extends DemoGacha {
    Person player = new Person("AAAA", 20);
    ArrayList<Double> _probs = new ArrayList<>(); // 確率のリスト
    double _totalProb;

    public MyApp() {
        super("My Gacha");
    }

    @Override
    public void initHeroes() {
        IMovable m;
        
        Hero hime = Hero.create("Hime", 19, 1, 100, 0,
            /*is_male*/false, /*variation*/"e");
        hime.home(w/2, h/2);
        setGachaHero(hime);

        Wizard taro = Wizard.create("Taro", 18, 1, 100, 150,
            /*is_male*/true, /*variation*/"");
        taro.home(w/2, h/2);
        setGachaHero(taro);

        m = new MoveHandle(
            CharaImageFile.getFilename(CharaImageFile.CATb),
            ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
            w/2, h/2);
        setGachaHero(m);
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

    public void run() {
        Printer.setTextWindow(textWindow);
        Printer.clear();
        Printer.println("Hello!\nLet's Gacha!");

        super.run();
    }

    public static void main(String[] args) {
        MyApp app = new MyApp();
        app.run();        
    }
}