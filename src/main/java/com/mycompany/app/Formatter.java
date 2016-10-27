/**
 * My package
 */
package com.mycompany.app;

/**
 * Formatter
 */
class Formatter {

    /**
     * Space count
     */
    private final int spaceCount = 4;

    /**
     *
     * @param code Code
     * @return formatted code
     */
    public String format(final String code) {
        StringBuilder builder = new StringBuilder(code.replace(" ", ""));

        int nestedLevel = 0;

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '{') {
                nestedLevel += 1;

                if (i < (builder.length() - 1)
                        && builder.charAt(i + 1) != '\n') {
                    builder.insert(i + 1, '\n');
                    i++;
                    continue;
                }
            }

            if (builder.charAt(i) == '}') {
                nestedLevel -= 1;

                if (i > 0 && builder.charAt(i - 1) != '\n') {
                    builder.insert(i, '\n');
                    i++;
                }

                if (i < (builder.length() - 1)
                        && builder.charAt(i + 1) != '\n') {
                    builder.insert(i + 1, '\n');
                    i++;
                }

                continue;
            }

            if (builder.charAt(i) == ';' && (i < builder.length() - 1)
                    && builder.charAt(i + 1) != '\n') {
                builder.insert(i + 1, '\n');
                i++;
            }

        }

        return builder.toString();
    }

}
