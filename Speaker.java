/* Speaker.java: (演習9-1)出力可能な抽象クラス
 * Interface:
   IPrintble: 会話文を出力
 * Overrides:
   prefix: print内での表示名
 * Childs:
   Person: 人間 */
public abstract class Speaker
  implements IPrintable
{
  public void print() {
    print("");
  }
  public void print(Object message) {
    String msg = String.format("[%s] ", prefix());
    Printer.print(msg);
    Printer.println(message);
  }
  protected abstract String prefix();
}