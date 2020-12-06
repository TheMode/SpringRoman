package fr.themode.roman.utils;

import java.util.TreeMap;

public final class RomanNumberUtils {

    private final static TreeMap<Integer, String> decimalToRomanMap = new TreeMap<>();
    private final static TreeMap<Character, Integer> romanToDecimalMap = new TreeMap<>();

    static {
        addEntry(1000, "M");
        addEntry(900, "CM");
        addEntry(500, "D");
        addEntry(400, "CD");
        addEntry(100, "C");
        addEntry(90, "XC");
        addEntry(50, "L");
        addEntry(40, "XL");
        addEntry(10, "X");
        addEntry(9, "IX");
        addEntry(5, "V");
        addEntry(4, "IV");
        addEntry(1, "I");
    }

    public static String toRoman(int number) {
        int l = decimalToRomanMap.floorKey(number);
        if (number == l) {
            return decimalToRomanMap.get(number);
        }
        return decimalToRomanMap.get(l) + toRoman(number - l);
    }

    public static int fromRoman(String number) {
        int result = 0;

        final int length = number.length();
        int num = 0;
        int previousNum = 0;
        for (int i = length - 1; i >= 0; i--) {
            char x = number.charAt(i);
            x = Character.toUpperCase(x);

            if (romanToDecimalMap.containsKey(x)) {
                previousNum = num;
                num = romanToDecimalMap.get(x);
            }

            if (num < previousNum) {
                result -= num;
            } else {
                result += num;
            }
        }

        return result;
    }

    private static void addEntry(int decimal, String roman) {
        decimalToRomanMap.put(decimal, roman);
        romanToDecimalMap.put(roman.charAt(0), decimal);
    }
}
