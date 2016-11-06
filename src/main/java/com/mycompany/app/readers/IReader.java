package com.mycompany.app.readers;

/**
 * Created by user on 11/1/16.
 */
public interface IReader {
    boolean hasChars();
    char readChar() throws EndOfSourceException;
}
