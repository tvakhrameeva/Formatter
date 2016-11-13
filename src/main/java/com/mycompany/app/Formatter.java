/**
 * My package
 */
package com.mycompany.app;

import com.mycompany.app.readers.EndOfSourceException;

import com.mycompany.app.readers.StringReader;

import com.mycompany.app.MoreThenOneLiteralInQuotes;



/**
 * Formatter
 */
class Formatter {

    /**
     * @param reader read
     * @return formatted code
     * @throws EndOfSourceException exception
     * @throws MoreThenOneLiteralInQuotes exception
     */
    public String format(final StringReader reader) throws EndOfSourceException, MoreThenOneLiteralInQuotes  {
        boolean openOnelineComment = false;
        boolean openMultilineComment = false;
        boolean openQuotes = false;
        boolean openDoubleQuotes = false;
        boolean co = false;
        String res = new String();
        boolean charRead = false;
        while (reader.hasChars()) {
            char buf = reader.readChar();
            if ((buf == '/') && (res.charAt(res.length() - 1) == '/')) {
                openOnelineComment = true;
            }
            if (openOnelineComment && (buf == '\n')) {
                openOnelineComment = false;
            }
            if ((buf == '*') && (res.charAt(res.length() - 1) == '/')) {
                openMultilineComment = true;
            }
            if (openMultilineComment && (buf == '/') && (res.charAt(res.length() - 1) == '*')) {
                openMultilineComment = false;
            }



            if (co && charRead) {
                if (buf == '\'') {
                    co = false;
                    charRead = false;
                    res = res + buf;
                    continue;
                } else {
                    throw new MoreThenOneLiteralInQuotes();
                }
            }
            if (co && (!charRead)) {
                if (buf != '\'') {
                    charRead = true;
                } else {
                    throw new MoreThenOneLiteralInQuotes();
                }
            }
            if (buf == '\'')  {
                co = true ;
                res = res + buf;
                continue;
            }





            if (buf == '\"') {
                if (!openDoubleQuotes) {
                    openDoubleQuotes = true;
                } else {
                    openDoubleQuotes = false;
                }
            }

            boolean smthOpen = (openOnelineComment || openMultilineComment || co || openDoubleQuotes);

            if ((buf == ';') && (!smthOpen)) {
                res = res + buf + '\n';
                continue;
            }

            if ((buf == '\n') && (!smthOpen)) {
                if (res.length() != 0) {
                    if (res.charAt(res.length() - 1) != '\n') {
                        res = res + buf;
                        continue;
                    }
                } else {
                    continue;
                }
            }


            if ((buf == '{') && (!smthOpen)) {
                res = res + buf + '\n';
                continue;
            }

            if ((buf == '}') && (res.length() != 0) && ((res.charAt(res.length() - 1)) != '\n') && (!smthOpen)) {
                res =  res + '\n' + buf + '\n' ;
                    continue;
                }

            if ((buf == '}') && (res.length() != 0) && ((res.charAt(res.length() - 1)) == '\n') && (!smthOpen)) {
                res =  res + buf + '\n';
                continue;
            }

            res = res + buf;
    }


             if (res.length() > 0 && res.charAt(res.length() - 1) == '\n') {
            res = res.substring(0, res.length() - 1);
        }
             return res;
    }

}
