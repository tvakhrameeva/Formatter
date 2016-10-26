package com.mycompany.app;

/**
 * Created by user on 10/26/16.
 */
class Formatter {

    private static int SpaceCount = 4;

    static String Format(String code)
    {
        StringBuilder builder = new StringBuilder(code.replace(" ", ""));

        int nestedLevel = 0;

        for(int i=0;i<builder.length();i++)
        {
            if (builder.charAt(i)=='{') {
                nestedLevel += 1;

                if (i < (builder.length() - 1) && builder.charAt(i+1) != '\n') {
                    builder.insert(i + 1, '\n');
                    i++;
                    continue;
                }
            }

            if (builder.charAt(i)=='}') {
                nestedLevel -= 1;

                if (i > 0 && builder.charAt(i - 1) != '\n') {
                    builder.insert(i, '\n');
                    i++;
                }

                if (i < (builder.length()-1) && builder.charAt(i+1) != '\n') {
                    builder.insert(i+1, '\n');
                    i++;
                }

                continue;
            }

            if (builder.charAt(i) == ';' && (i < builder.length() - 1) && builder.charAt(i + 1) != '\n')
            {
                builder.insert(i + 1, '\n');
                i++;
            }

        }

        return builder.toString();
    }

}
