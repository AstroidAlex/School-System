package org.example;

public class Util {
    public static String toTitleCase(String str){
        if (str == null) {
            return null;
        }
        String result = " ";

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
