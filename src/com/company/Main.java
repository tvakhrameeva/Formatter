package com.company;

public class Main {

    public static void main(String[] args) {
	    String testCode = "{ command1; { command2; } command3;}";

        System.out.println("Given code:\n" + testCode);
        System.out.println("Code after formatting:\n" + Formatter.Format(testCode));
    }
}
