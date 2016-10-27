/**
 * My package
 */
package com.mycompany.app;

/**
 * Hello world!
 *
 */
public final class App {

    private App() {
    }

    /**
     *
     * @param args Arguments
     */
    public static void main(final String[] args) {
        Formatter formatter = new Formatter();

        String testCode = "{ command1; { command2; } command3;}";

        System.out.println("Given code:\n" + testCode);
        System.out.println("Code after formatting:\n" +
                formatter.format(testCode));
    }
}
