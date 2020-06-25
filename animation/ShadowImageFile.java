package animation;

public class ShadowImageFile extends ImageFileBase {
	public static String BASENAME = "img/chara/pipo-shadow";
	public static String EXT = ".png";

	public static String DEFAULT = "001";
	public static String NORMAL = "001";
	public static String ANIMAL = "002";
	public static String MIDDLE = "003";
	public static String LARGE = "004";
	
	public static String getFilename(String name) {
		return getFilename(BASENAME, name, EXT);
	}
}
