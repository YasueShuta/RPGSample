import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	AnimCanvas canvas;
	int status;
	
	public ButtonListener(AnimCanvas canvas, int status) {
		// status: start(1), stop(0)
		this.canvas = canvas;
		this.status = status;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.status = status;
	}
	
	public static ButtonListener starter(AnimCanvas canvas) {
		ButtonListener ret = new ButtonListener(canvas, 1);
		return ret;
		
	}

	public static ButtonListener stopper(AnimCanvas canvas) {
		ButtonListener ret = new ButtonListener(canvas, 0);
		return ret;
		
	}
}
