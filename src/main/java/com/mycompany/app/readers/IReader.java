package com.mycompany.app.readers;



/**
 * Created by user on 11/1/16.
 *
 *
 */
public interface IReader {
    /**
     *
     * @return boolean
     */
    boolean hasChars();

    /**
     *
     * @return char
     * @throws EndOfSourceException exception
     */
    char readChar() throws EndOfSourceException;
}
