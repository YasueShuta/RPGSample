/* Printer.java: (演習9-1)出力クラス
IPrintableで用いる出力.最初はSystem.out.printlnを用いる. */
public class Printer {
	static animation.TextWindow _txtw = null;
	
	static public void print(Object message) {
		if (_txtw == null) {		  
		    System.out.print(message);
		} else {
			_txtw.print_(message);
		}
	}
	static public void println(Object message) {
		if (_txtw == null) {
			System.out.println(message);
		} else {
			_txtw.println(message);
		}
	}
}