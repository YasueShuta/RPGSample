import java.util.*;
/* enshu10-1: TODO */
//import animation.*;

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
  public static void main(String[] args) {
    //test();
    /* enshu10-1: TODO */
    //DemoWindow.main(args);
  }
}