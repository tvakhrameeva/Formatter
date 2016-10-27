/**
 * My package
 */
package com.mycompany.app;

/**
 * Formatter
 */
class Formatter {

    /**
     *
     * @param code Code
     * @return formatted code
     */
    public String format(final String code) {
        StringBuilder builder = new StringBuilder(code.replace(" ", ""));

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '{') {

                if (i < (builder.length() - 1)
                        && builder.charAt(i + 1) != '\n') {
                    builder.insert(i + 1, '\n');
                    i++;
                    continue;
                }
            }

            if (builder.charAt(i) == '}') {

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
