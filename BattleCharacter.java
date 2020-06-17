/* Person.java: (演習9-3)戦闘可能な登場人物クラス
 * Interface:
   IPrintable:(継承)会話文を出力
   IBattlable: 戦闘可能
 * Parent:
   Character
 * Childs:
   Hero: 勇者(予定)
   Wizard: 魔法使い(予定)
   Priest: 僧侶(予定) */
public class BattleCharacter
  extends MyCharacter
  implements IBattlable
{
  /* プロパティ */
  int _maxhp;
  int _hp;
  int _maxmp;
  int _mp;

  /* コンストラクタ */
  public BattleCharacter(String name, int age, String _class, int level) {
    this(name, age, _class, level, 100, 0);
  }
  public BattleCharacter(String name, int age, String _class, int level, int hp, int mp) {
    super(name, age, _class, level);
    _maxhp = hp;
    _maxmp = mp;
    _hp = _maxhp;
    _mp = _maxmp;
  }

  /* 公開メソッド */
  public int hp() {
    return _hp;
  }
  public int mp() {
    return _mp;
  }
  public void attack(IBattlable other) {
    attack(other, 5); //固定ダメージ
  }
  public void attack(IBattlable other, int point) {
    Printer.println(_name+"の攻撃!");
    other.damage(point);
  }
  public void damage(int point) {
    Printer.println(_name+"は"+point+"のダメージを受けた.");
    _hp -= point;
    if (_hp <= 0) {
      _hp = 0;
      lose();
    }
  }
  public void heal(int point) {
    if (_hp + point > _maxhp) {
      point = _maxhp - _hp;
    }
    Printer.println(_name+"のHPが"+point+"回復した.");
    _hp += point;
  }
  public void win() {
    Printer.println(_name+"は戦闘に勝利した.");
  }
  public void lose() {
    Printer.println(_name+"は倒れた.");
  }
}