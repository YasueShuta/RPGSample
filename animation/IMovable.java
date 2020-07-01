package animation;

public interface IMovable extends IAnimation {
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
	
	void move(int dx, int dy);
	void move(int dx, int dy, double speed);
	void move(int dx, int dy, int duration);
	
	void down(int d);
	void left(int d);
	void up(int d);
	void right(int d);
	
	void wait(int duration);
	void randomWalk();
	void randomWalk(int d);
	void jump();
	
	void home();
	void home(int px, int py);
		
	void forward(int d);
	void back(int d);
	void turnLeft();
	void turnRight();
	void turn(int duration, boolean clockwise);
	
	void update();
	void countup();
}
