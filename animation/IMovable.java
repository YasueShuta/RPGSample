package animation;

public interface IMovable extends IDrawable {
	String[] DIRECTIONS = {"down", "left", "up", "right"};
	String[] STATES = {"idle", "walk"};

	String direction();
	void direction(String d);
	String state();
	void state(String s);

	double speed();
	void speed(double speed);
	double[] velocity();
	void velocity(double vx, double vy);
	
	void down(int d);
	void left(int d);
	void up(int d);
	void right(int d);
	void stop();
	void home();
	void home(int px, int py);
		
	void turnLeft();
	void turnRight();
	
	void update();
	void countup();
}
