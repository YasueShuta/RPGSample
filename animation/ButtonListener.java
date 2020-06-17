package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
	AppBase _app = null;
	
	public ButtonListener(AppBase app) {
		_app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_app.onButtonPressed(e);
	}	
}
