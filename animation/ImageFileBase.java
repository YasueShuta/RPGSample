package animation;

public abstract class ImageFileBase {
	public static String getFilename(String basename, String name, String ext) {
		return basename + name + ext;
	}
}
