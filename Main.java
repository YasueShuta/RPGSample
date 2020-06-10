class Main {
 /*
  static void test() {
    BattleCharacter hero = new BattleCharacter("勇者", 15, "Hero", 50, 100, 100);
    BattleCharacter satan = new BattleCharacter("魔王", 300, "Satan", 100, 300, 5000);

    hero.attack(satan);
    satan.attack(hero, 300);
  }
*/

  public static void main(String[] args) {
    Person taro = new Person("Taro", 18);
    Person hime = new Person("Hime", 19);

    taro.hello_to(hime);
  }
}