package es.esy.kapcapx.UI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SymbolLimit extends PlainDocument {
    private int limit;

    public SymbolLimit(int limit) {
        this.limit = limit;
    }

    public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
