/* Printer.java: (演習9-1)出力クラス
IPrintableで用いる出力.最初はSystem.out.printlnを用いる. */
import animation.TextWindow;

public class Printer {
    static private TextWindow _window = null;

    static public void setTextWindow(TextWindow w) {
        _window = w;
    }

    static public void print(Object message) {
        if (_window != null) {
            _window.print_(message);
        } else {
            System.out.print(message);
        }
    }

    static public void println(Object message) {
        if (_window != null) {
            _window.println(message);
        } else {
            System.out.println(message);
        }
    }

    static public void clear() {
        if (_window != null) {
            _window.clear();
        }
    }
}