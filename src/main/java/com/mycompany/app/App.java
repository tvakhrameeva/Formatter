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
     * @throws EndOfSourceException exception
     * @throws MoreThenOneLiteralInQuotes exception
     */
    public static void main(final String[] args) throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        Formatter formatter = new Formatter();

        StringReader testReader = new StringReader("eee\\y''\\");

        System.out.println("Given code:\n" + testReader);
        System.out.println("Code after formatting:\n" +
                formatter.format(testReader));
    }
}
