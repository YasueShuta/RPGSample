package animation;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyCellRenderer extends JLabel implements ListCellRenderer {
    static Color _selectedFillColor;
    static Color _selectedFontColor;// = Color.WHITE;
    static Color _fillColor;// = new Color(0, 64, 128, 128);
    static Color _fontColor;// = Color.BLACK;

    public Component getListCellRendererComponent(
      JList list,              // the list
      Object value,            // value to display
      int index,               // cell index
      boolean isSelected,      // is the cell selected
      boolean cellHasFocus)    // does the cell have focus
    {
        String s = value.toString();
        setText(s);

        if (isSelected) {
            setBackground(_selectedFillColor);
            setForeground(_selectedFontColor);
        } else {
            setBackground(_fillColor);
            setForeground(_fontColor);
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
    
    public void setParams(Color fillColor, Color fontColor, Color selectedFillColor, Color selectedFontColor) {
        _fillColor = fillColor;
        _fontColor = fontColor;
        _selectedFillColor = selectedFillColor;
        _selectedFontColor = selectedFontColor;
    }

}