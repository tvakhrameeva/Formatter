package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String testCode = "{ command1; { command2; } command3;}";

        System.out.println("Given code:\n" + testCode);
        System.out.println("Code after formatting:\n" + Formatter.Format(testCode));
    }
}
