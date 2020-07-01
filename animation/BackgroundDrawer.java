package animation;

import java.awt.Graphics;

public class BackgroundDrawer extends DrawableHandle implements IDrawable {
	public static String GRASS = "001";
	public static String FOREST = "002";
	public static String SAND = "003";
	public static String DESERT = "004";
	public static String SNOW = "005";
	public static String MOUNTAIN = "006";
	public static String OCEAN = "007";
	public static String CAVE = "008";
	public static String CASTLE = "009";
	public static String DARK = "010";
	
	static String SRCFILE_BASENAME = "img/back/pipo-battlebg";
	static String SRCFILE_EXT = ".jpg";

	public BackgroundDrawer() {
		this(GRASS);
	}
	public BackgroundDrawer(String name) {
		super(SRCFILE_BASENAME + name + SRCFILE_EXT, 1.0);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(_srcimg.getImage(), 0, 0, _srcimg.w, _srcimg.h, null);
	}

}
