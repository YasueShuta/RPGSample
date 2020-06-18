/* Hero.java: 勇者クラス */
import animation.*;

public class Hero
  extends BattleCharacter
{
  /* プロパティ */
  static String className = "Hero";

  /* コンストラクタ */
  public Hero(String name, int age, int level) {
    this(name, age, level, 100, 0);
  }
  public Hero(String name, int age, int level, int hp, int mp) {
    this(name, age, level, hp, mp,
      CharaImageFile.FIGHTER_MALE, ShadowImageFile.DEFAULT);
  }
  public Hero(String name, int age, int level, int hp, int mp, String srcname, String shadowname) {
    this(name, age, level, hp, mp, srcname, shadowname, false);
  }
  public Hero(String name, int age, int level, int hp, int mp, String srcname, String shadowname, boolean playable) {
    super(name, age, className, level, hp, mp, srcname, shadowname, playable);
  }

  public static Hero create(String name, int age, int level) {
    return create(name, age, level, true, "");
  }
  public static Hero create(String name, int age, int level, boolean is_male, String variation) {
    return create(name, age, level, is_male, variation, false);
  }
  public static Hero create(String name, int age, int level, boolean is_male, String variation, boolean playable) {
    String srcname = is_male ? CharaImageFile.FIGHTER_MALE : CharaImageFile.FIGHTER_FEMALE;
    srcname += variation;
    String shadowname = ShadowImageFile.DEFAULT;

    return new Hero(name, age, level, 100, 0, srcname, shadowname, playable);
  }
}

