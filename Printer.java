/* Printer.java: (演習9-1)出力クラス
IPrintableで用いる出力.最初はSystem.out.printlnを用いる. */
public class Printer {
  static public void print(Object message) {
    System.out.print(message);
  }
  static public void println(Object message) {
    System.out.println(message);
  }
}