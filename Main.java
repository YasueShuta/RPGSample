class Main {
/* 
  static void test() {
    BattleCharacter hero = new BattleCharacter("勇者", 15, 100, 100);
    BattleCharacter maou = new BattleCharacter("魔王", 300, 300, 5000);

    hero.attack(maou);
    maou.attack(hero, 300);
  }
*/

  public static void main(String[] args) {
    Person taro = new Person("Taro", 18);
    Person hime = new Person("Hime", 19);

    taro.hello_to(hime);
  }
}