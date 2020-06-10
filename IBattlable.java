/* IBattlable.java: (演習9-3)戦闘用インタフェース
 * Methods:
   hp: 体力プロパティの取得
   mp: 魔力プロパティの取得
   attack: 攻撃
   damage: 指定したポイントだけ体力を減少させる
   heal: 指定したポイントだけ体力を回復する
   win: 勝利
   lose: 戦闘不能
 * Implements:
   BattleCharacter: 戦闘職のキャラクター
   BattleEnemy: 戦闘可能な敵キャラクター(予定) */
public interface IBattlable {
  int hp();
  int mp();
  void attack(IBattlable other);
  void attack(IBattlable other, int point);
  void damage(int point);
  void heal(int point);
  void win();
  void lose();
}