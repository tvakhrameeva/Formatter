package com.mycompany.app.readers;

/**
 * Created by user on 11/1/16.
 */
public class StringReader implements IReader {
    private String s = new String();
    private int i = 0;

    /**
     * @param str
     */
    public StringReader(final String str) {
        s = new String(str);

    }
    /**
     * @return boolean
     */
    public boolean hasChars() {
        if (i == s.length()) {
            return false;
        }
        return true;
    }
    /**
     * @return buf
     */
    public char readChar() throws EndOfSourceException {
        if (!hasChars()) {
            throw new EndOfSourceException();
        }
        char buf = s.charAt(i);
        i++;
        return buf;
    }
}
