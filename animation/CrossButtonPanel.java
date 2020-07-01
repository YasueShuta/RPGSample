package animation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CrossButtonPanel extends JPanel {
	AppBase _app;
	
	public CrossButtonPanel(AppBase app) {
		init(app);
	}

	public CrossButtonPanel(AppBase app, LayoutManager layout) {
		super(layout);
		init(app);
	}

	public CrossButtonPanel(AppBase app, boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		init(app);
	}

	public CrossButtonPanel(AppBase app, LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		init(app);
	}

	private void init(AppBase app) {
		_app = app;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		ActionListener lsnr = new ButtonListener(_app);
		
		// upボタン
		JButton b_up = new JButton("↑");
		b_up.setActionCommand(ButtonCommand.UP);
		b_up.addActionListener(lsnr);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(b_up, gbc);
		
		// leftボタン
		JButton b_left = new JButton("←");
		b_left.setActionCommand(ButtonCommand.LEFT);
		b_left.addActionListener(lsnr);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(b_left, gbc);
		
		// rightボタン
		JButton b_right = new JButton("→");
		b_right.setActionCommand(ButtonCommand.RIGHT);
		b_right.addActionListener(lsnr);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(b_right, gbc);
		
		// downボタン
		JButton b_down = new JButton("↓");
		b_down.setActionCommand(ButtonCommand.DOWN);
		b_down.addActionListener(lsnr);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(b_down, gbc);

		// 決定ボタン
		JButton b_center = new JButton("o");
		b_center.setActionCommand(ButtonCommand.ENTER);
		b_center.addActionListener(lsnr);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(b_center, gbc);

		// キャンセルボタン
		JButton b_cancel = new JButton("×");
		b_cancel.setActionCommand(ButtonCommand.CANCEL);
		b_cancel.addActionListener(lsnr);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(b_cancel, gbc);

	}
}
