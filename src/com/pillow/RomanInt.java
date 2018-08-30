/*
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 */
package com.pillow;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
class RomanInt {
    private Map<Character, Integer> R2I() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = R2I();
        int n = 0;
        int l = s.length();
        for (int i = 0; i < l; i ++) {
            char c = s.charAt(i);
            if ((i + 1 < l) &&
                ((c == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ||
                (c == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ||
                (c == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))) {
                    n += map.get(s.charAt(i + 1)) - map.get(c);
                    i ++;
                }
                 else 
                     n += map.get(c);
        }
        return n;
    }
    
    private Map<Integer, String> I2R() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }

    public String intToRoman(int num) {
        List<Integer> l = new LinkedList<>();
        while (num > 0) {
            int n = num % 10;
            num = num / 10;
            l.add(0, n);
        }

        Map<Integer, String> map = I2R();
        int len = l.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i ++) {
            int n = l.get(i) * (int)Math.pow(10, len - i - 1);
            if (map.containsKey(n))
                sb.append(map.get(n));
            else {
                int k1 = 0;
                int k2 = 0;
                if (n > 1000) {
                    k1 = 0;
                    k2 = 1000;
                } else if (n > 500) {
                    k1 = 500;
                    k2 = 100;
                } else if (n > 100) {
                    k1 = 0;
                    k2 = 100;
                } else if (n > 50) {
                    k1 = 50;
                    k2 = 10;
                } else if (n > 10) {
                    k1 = 0;
                    k2 = 10;
                } else if (n > 5) {
                    k1 = 5;
                    k2 = 1;
                } else if (n > 0) {
                    k1 = 0;
                    k2 = 1;
                }
                if (k1 != 0)
                    sb.append(map.get(k1));
                if (k2 != 0)
                for (int j = 0; j < (n - k1) / k2; j ++)
                    sb.append(map.get(k2));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        RomanInt s = new RomanInt();
/*        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));
*/
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
        System.out.println(s.intToRoman(10));
    }
}
