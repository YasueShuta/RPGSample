/* Person.java: (演習9-1)人間クラス
 * Interface:
   IPrintable:(継承)会話文を出力
   ITalkable: 会話可能
 * Parent:
   Speaker
 * Childs:
   Character: ゲーム内に登場する人物 */
public class Person
  extends Speaker
  implements ITalkable
{
  /* プロパティ */
  protected String _name = "";
  protected int _age = 0;

  /* コンストラクタ */
  public Person(){}
  public Person(String name, int age) {
    _name = name;
    _age = age;
  }

  /* 公開メソッド */
  public String name() {
    return _name;
  }
  public int age() {
    return _age;
  }
  public void hello_to(Person other) {
    hello(other);
    say_name_age();
    other.hello(this);
    other.say_name_age();
  }
  public void talkTo(ITalkable other, String ... args) {
    print("こんにちは.");
    other.answerTo(this, args);
  }
  public void answerTo(ITalkable other, String[] args) {
    for (String s : args) {
      print(s);
    }
  }

  /* 非公開メソッド */
  void hello(Person other) {
    String msg = String.format("Hello, %s.", other.name());
    print(msg);
  }
  void say_name_age() {
    String msg = String.format("I'm %s, %d.", _name, _age);
    print(msg);
  }
  
  protected String prefix() {
    return _name;
  }

}