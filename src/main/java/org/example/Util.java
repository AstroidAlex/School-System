package org.example;

public class Util {
    /**
     * Takes a string and seperates it into parts at every space, then uppercases the first letter
     * @param str is the string that will be put into title case
     * @return the string in title case for every word
     */
    public static String toTitleCase(String str){
        if (str == null) {
            return null;
        }
        String result = "";
        String[] parts = str.split(" ");
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            String firstChar = part.substring(0,1).toUpperCase();
            String restOfString = part.substring(1).toLowerCase();
            result += firstChar + restOfString + " ";
        }

        return result.trim();
    }
}