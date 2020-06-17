import animation.CharaImageFile;
import animation.ShadowImageFile;

public class Hero extends PlayableBattleCharacter {
	
	static String srcname = CharaImageFile.FIGHTER_MALEe;
	static String shadowname = ShadowImageFile.DEFAULT;

	public Hero(String name, int age, boolean playable) {
		this(name, age, 1, 100, 0, playable);
	}

	public Hero(String name, int age, int level, int hp, int mp, boolean playable) {
		super(name, age, "Hero", srcname, shadowname, level, hp, mp, playable);
	}

}
