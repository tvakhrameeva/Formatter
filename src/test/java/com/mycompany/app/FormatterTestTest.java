package com.mycompany.app;

import com.mycompany.app.readers.EndOfSourceException;
import com.mycompany.app.readers.StringReader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FormatterTestTest extends TestCase  {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FormatterTestTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(FormatterTestTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testFormatterTest22() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("eeee;{};lmm");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(new String("eeee;\n{\n}\n;\nlmm")));
    }
    public void testFormatterTest1() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("eeeeeeee");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(new String( "eeeeeeee")));
    }
    public void testFormatterTest2() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("eeee;");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals("eeee;"));
    }
    public void testFormatterTest3() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("eeee;e");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals("eeee;\ne"));
    }
    public void testFormatterTest4() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader(";");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(";"));
    }
    public void testFormatterTest5() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("\n;");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(";"));
    }

    public void testFormatterTest6() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("{{{{");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals("{\n{\n{\n{"));
    }
    public void testFormatterTest7() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("}}}}");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals("}\n}\n}\n}"));
    }
    public void testFormatterTest8() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("\n");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(""));
    }

    public void testFormatterTest9() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals(""));
    }
    public void testFormatterTest10() throws EndOfSourceException, MoreThenOneLiteralInQuotes {
        StringReader reader = new StringReader("u\n");
        Formatter formatter = new Formatter();
        assertTrue(formatter.format(reader).equals("u"));
    }
}