package com.mycompany.app.readers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StringReaderTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StringReaderTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StringReaderTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testStringReader() {
        StringReader stringReader= new StringReader("fdc");
        assertTrue(stringReader.hasChars());
        assertTrue(stringReader.readChar()=='f');
        assertTrue(stringReader.readChar()=='d');
        assertTrue(stringReader.readChar()=='c');
        assertFalse(stringReader.hasChars());
    }
}