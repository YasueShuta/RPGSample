/* ITalkable.java: (演習9-2)会話メソッドのインタフェース
 * Methods:
   talkTo: 話しかける
   answerTo: 受け答える
 * Implements:
   Person: 人間
   Animal: 動物(予定)
   Monster: 魔物(予定) */
public interface ITalkable {
  void talkTo(ITalkable other, String ... args);
  void answerTo(ITalkable other, String[] args);
}