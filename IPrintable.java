/* IPrintable.java: (演習9-1)printメソッドのインタフェース
 * Methods:
   print: 会話文の出力
 * Implements:
   Speaker: 出力可能な抽象クラス */
public interface IPrintable {
  void print();
  void print(Object message);
}