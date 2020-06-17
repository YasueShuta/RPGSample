package animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CommandWindow extends JPanel {
	private int _w, _h;
	private JList<String> _list;
	private Color _fillColor;
//	private int _borderWidth;
//	private Color _borderColor;
//	private int _marginWidth;
	private Color _fontColor;
	private int _fontsize;

	public CommandWindow(int w, int h, int fontSize) {
		this(w, h, new Color(0, 64, 128, 128),
				//3, Color.BLACK, 8,
				fontSize, null);
	}
	public CommandWindow(int w, int h, Color fillColor,
			//int borderWidth, Color borderColor, int marginWidth,
			int fontSize, Color fontColor) {
		
		_w = w;
		if (h == 0) _h = (int)(4.8 * fontSize);
		else _h = h;
		_fillColor = fillColor;
//		_borderWidth = borderWidth;
//		_borderColor = borderColor;
//		_marginWidth = marginWidth;
		_fontsize = fontSize;
		_fontColor = fontColor;
		
		init();
	}

	void init() {
		setBackground(_fillColor);
		
		String[] items = {"はい", "いいえ", "A", "B", "C"};
		_list = new JList<String>(items);
		_list.setFont(new Font("MSゴシック", Font.BOLD, _fontsize));
		MyCellRenderer renderer = new MyCellRenderer();
		Color selectedFillColor = new Color(196, 128, 0);
		Color selectedFontColor = Color.WHITE;
		renderer.setParams(_fillColor, _fontColor, selectedFillColor, selectedFontColor);
		_list.setCellRenderer(renderer);
		_list.setSelectedIndex(0);

		JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(_list);
		sp.setPreferredSize(new Dimension(_w, _h));
		
		add(sp);
		setVisible(false);
	}
	
	public void moveCursor(int d) {
		int index = _list.getSelectedIndex();
		if (index < 0) return;
		int len = _list.getModel().getSize();
		index = (index + d) % len;
		while (index < 0) index += len;
		_list.setSelectedIndex(index);
	}
	
	public String getSelectedValue() {
		return _list.getSelectedValue();
	}
	public int getSelectedIndex() {
		return _list.getSelectedIndex();
	}
	
	public void setList(String[] items) {
		_list.setListData(items);
		_list.setSelectedIndex(0);
	}
}
