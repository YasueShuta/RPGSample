/* Person.java: (演習9-2)登場人物クラス
 * Interface:
   IPrintable:(継承)会話文を出力
   ITalkable: (継承)会話可能
 * Parent:
   Person
 * Childs:
   BattleCharacter: 戦闘可能な登場人物 */
public abstract class Character
    extends Person
{
  /* プロパティ */
  public String _class;
  public int _level;

  /* コンストラクタ */
  public Character(String name, int age, String _class, int level) {
    super(name, age);
    this._class = _class;
    _level = level;
  }
 
  /* 公開メソッド */
  public String _class() {
    return _class;
  }
  public int level() {
    return _level;
  }
  public void levelup() {
    levelup(1);
  }
  public void levelup(int level) {
    Printer.print(_name + "のレベルが");
    Printer.println(level + "上がった.");
    _level += level;
    }
}
