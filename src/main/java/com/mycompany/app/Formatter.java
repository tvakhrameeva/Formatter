/**
 * My package
 */
package com.mycompany.app;

import com.mycompany.app.readers.EndOfSourceException;
import com.mycompany.app.readers.IReader;
import com.mycompany.app.readers.StringReader;

/**
 * Formatter
 */
class Formatter {

    /**
     * @param code Code
     * @return formatted code
     */
    public String format(final StringReader reader) throws EndOfSourceException {
        String res = new String();
        while (reader.hasChars()) {
            char buf = reader.readChar();
            if (buf == ';') {
                res = res + buf + '\n';
                continue;
            }

            if (buf == '\n') {
                if (res.length() != 0) {
                    if (res.charAt(res.length() - 1) != '\n') {
                        res = res + buf;
                        continue;
                    }
                }
                else {continue;}
            }


            if (buf == '{'){
                res = res + buf + '\n';
                continue;
            }

            if ((buf == '}') && (res.length() != 0)&&((res.charAt(res.length() - 1)) != '\n')){
                res =  res + '\n'+ buf + '\n';
                    continue;
                }

            if ((buf == '}') && (res.length() != 0)&& ((res.charAt(res.length() - 1)) == '\n')){
                res =  res + buf + '\n';
                continue;
            }

            res= res+ buf;
    }


             if (res.length() > 0 && res.charAt(res.length()-1) == '\n') {
            res= res.substring(0,res.length()-1);
        }
             return res;
    }

}
