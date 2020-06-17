package animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextWindow extends JPanel {
	private int _w, _h;
	private JLabel _label;
	private JScrollPane _sp;
	
	private Color _fillColor;
	private int _borderWidth;
	private Color _borderColor;
	private int _marginWidth;
	private Color _fontColor;
	private int _fontsize;
	
	private boolean _clearFlag = false;

	public TextWindow(int w, int h, int fontSize) {
		this(w, h, new Color(0, 64, 128, 128),
				3, Color.BLACK, 8, fontSize, null);
	}
	public TextWindow(int w, int h, Color fillColor,
			int borderWidth, Color borderColor, int marginWidth,
			int fontSize, Color fontColor) {
		
		_w = w;
		if (h == 0) _h = (int)(4.8 * fontSize);
		else _h = h;
		_fillColor = fillColor;
		_borderWidth = borderWidth;
		_borderColor = borderColor;
		_marginWidth = marginWidth;
		_fontsize = fontSize;
		_fontColor = fontColor;
		
		init();
	}
	
	private void init() {
		setBackground(_fillColor);
		
		_label = new JLabel("", JLabel.LEFT);
		_label.setFont(new Font("MSゴシック", Font.BOLD, _fontsize));
		
		setScrollPane();
	}
	
	private void setScrollPane() {		
		_sp = new JScrollPane();
		_sp.getViewport().setView(_label);
		_sp.setPreferredSize(new Dimension(_w, _h));
		add(_sp);
		
	}
/*
	public Dimension getWindowSize() {
		return new Dimension(_w, _h);
	}
	public void setWindowSize(int w, int h) {
		_w = w;
		_h = h;
		remove(_sp);
		setScrollPane();
	}
*/	
	public void setText(String msg) {
		String s = "<html>" + msg.replaceAll("\\n", "<br>") + "</html>";
		_label.setForeground(_fontColor);
		_label.setText(s);
		
		// 1番下までスクロール
		_sp.getVerticalScrollBar().setValue(0);
		_sp.getViewport().scrollRectToVisible(new Rectangle(0, Integer.MAX_VALUE - 1, 1, 1));
	}
	public String getText() {
		String s = _label.getText();
		return s.replaceAll("</?html>", "").replaceAll("<br>", "\n");
	}
	public void print_(Object msg) {
		if (_clearFlag) {
			clear();
			_clearFlag = false;
		}
		String s = getText();
		s += msg;
		setText(s);
		System.out.print(s);
	}
	public void println(Object msg) {
		println(msg, true);
	}
	public void println(Object msg, boolean clear) {
		print_(msg + "\n");		
		_clearFlag = clear;
	}
	public void clear() {
		_label.setText("");
	}

}
