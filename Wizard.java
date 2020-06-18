/* Wizard.java: 魔法使いクラス */
import animation.*;

public class Wizard
  extends BattleCharacter
{
  /* プロパティ */
  static String className = "Wizard";

  /* コンストラクタ */
  public Wizard(String name, int age, int level) {
    this(name, age, level, 50, 100);
  }
  public Wizard(String name, int age, int level, int hp, int mp) {
    this(name, age, level, hp, mp,
      CharaImageFile.WIZARD_FEMALE, ShadowImageFile.DEFAULT);
  }
  public Wizard(String name, int age, int level, int hp, int mp, String srcname, String shadowname) {
    this(name, age, level, hp, mp, srcname, shadowname, false);
  }
  public Wizard(String name, int age, int level, int hp, int mp, String srcname, String shadowname, boolean playable) {
    super(name, age, className, level, hp, mp, srcname, shadowname, playable);
  }

  public static Wizard create(String name, int age, int level) {
    return create(name, age, level, true, "");
  }
  public static Wizard create(String name, int age, int level, boolean is_male, String variation) {
    return create(name, age, level, is_male, variation, false);
  }
  public static Wizard create(String name, int age, int level, boolean is_male, String variation, boolean playable) {
    String srcname = is_male ? CharaImageFile.WIZARD_MALE : CharaImageFile.WIZARD_FEMALE;
    srcname += variation;
    String shadowname = ShadowImageFile.DEFAULT;

    return new Wizard(name, age, level, 50, 100, srcname, shadowname, playable);
  }
}

