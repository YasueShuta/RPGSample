package animation;

public class GachaImageFile extends ImageFileBase {
	public static String BASENAME = "img/gacha/pipo-";
	public static String EXT = ".png";
	
	public static String CURTAIN_OPEN = "curtain1";
	public static String CURTAIN_CLOSE = "curtain2";
	public static String TAKARABAKO1 = "takarabakoanime01";
	public static String TAKARABAKO2 = "takarabakoanime02";
	public static String TAKARABAKO6 = "takarabakoanime06";
	
	public static String getFilename(String name) {
		return getFilename(BASENAME, name, EXT);
	}
}
