/**
 * My package
 */
package com.mycompany.app;

import com.mycompany.app.readers.EndOfSourceException;

import com.mycompany.app.readers.StringReader;

/**
 * Hello world!
 *
 */
public final class App  {

    private App() {
    }

    /**
     *
     * @param args Arguments
     * @throws EndOfSourceException
     */
    public static void main(final String[] args) throws EndOfSourceException {
        Formatter formatter = new Formatter();

        StringReader testReader = new StringReader("eeeeeeeek");

        System.out.println("Given code:\n" + testReader);
        System.out.println("Code after formatting:\n" +
                formatter.format(testReader));
    }
}
