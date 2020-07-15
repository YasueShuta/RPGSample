import animation.*;
import java.util.*;

public class GachaSample extends DemoGacha {
    Person player;
    ArrayList<Double> _probs = new ArrayList<>(); // 確率のリスト
    double _totalProb;

    public GachaSample() {
        this("AAAA");
    }
    public GachaSample(String name) {
        super("My Gacha");
        player = new Person(name, 20);
    }

    @Override
    public void initHeroes() {
        IMovable m;
        
        Hero hime = Hero.create("Hime", 19, 1, 100, 0,
            /*is_male*/false, /*variation*/"e");
        hime.home(w/2, h/2);
        hime.setRarity(3);
        hime.setPhrase("Watashi ga Hime yo!");
        setGachaHero(hime);

        Wizard taro = Wizard.create("Taro", 18, 1, 100, 150,
            /*is_male*/true, /*variation*/"");
        taro.home(w/2, h/2);
        taro.setRarity(2);
        taro.setPhrase("%name% san, Konnichiha.");
        setGachaHero(taro);

        m = new MoveHandle(
            CharaImageFile.getFilename(CharaImageFile.CATb),
            ShadowImageFile.getFilename(ShadowImageFile.ANIMAL),
            w/2, h/2);
        setGachaHero(m);
    }

    @Override
    public void setGachaHero(IMovable m) {
        m.home(w/2, h/2);
        super.setGachaHero(m);

        double p;
        if (m instanceof Character) {
            p = ((Character)m).getProb();
        } else {
            p = 5d;
        }
        _probs.add(p);
        _totalProb += p;
    }

    @Override
    public void choice() {
        //super.choice();
        double d = rd.nextDouble() * _totalProb;
        double sum = 0d;
        for (int i=0; i<heroes.size(); i++) {
            sum += _probs.get(i);
            if (sum >= d) {
                cast = heroes.get(i);
                cast.direction("right");
                cast.setVisible(true);
                break;
            }
        }

        Printer.clear();
        String s;
        if (cast instanceof Character) {
            s = ((Character)cast).getRarity();
        } else {
            s = "Normal";
        }
        Printer.println("Success!: " + s);
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
        GachaSample app = new GachaSample();
        app.run();        
    }
}