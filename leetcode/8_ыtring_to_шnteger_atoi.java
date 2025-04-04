// https://leetcode.com/problems/string-to-integer-atoi/submissions/1596047268/

class Solution {
    public int myAtoi(String s) {
        // char idx - 30

        boolean is_ws_phase = true;
        boolean is_leading_zero_phase = true;
        boolean is_digit_phase = false;

        char sign = '+';

        List<Character> digit_list = new ArrayList<Character>();
        for (int i=0; i<s.length(); i++) {
            if (is_ws_phase) {
                char c = s.charAt(i);
                if (c == ' ') {
                    continue;
                } else if (c == '-' || c == '+') {
                    sign = c;
                    is_ws_phase = false;
                    is_digit_phase = true;
                    continue;
                } else if (!((int)'0' <= (int)c && (int)c <= (int)'9')) {
                    return 0;
                } else {
                    is_ws_phase = false;
                    is_digit_phase = true;
                }
            }
            if (is_digit_phase) {
                char c = s.charAt(i);
                if(is_leading_zero_phase && c == '0') {
                    continue;
                }
                is_leading_zero_phase = false;
                if ((int)'0' <= (int)c && (int)c <= (int)'9') {
                    digit_list.add(c);
                } else {
                    break;
                }
            }
        }

        // 4294967296 -> 10 
        if (digit_list.size() > 10) {
            if (sign == '+') {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        double number = 0;
        int position = digit_list.size() - 1;
        for (int i=0; i<digit_list.size(); i++) {
            // 1 -> 10^0
            // 10 -> 10^1
            double current_number = ((int)digit_list.get(i) - 0x30) * Math.pow(10, position);
            position--;
            number += current_number;
        }

        if (number > Integer.MAX_VALUE) {
            if (sign == '+') {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        // return digit_list.size();
        // return digit_list.get(0);

        if (sign == '+') {
            return (int)number;
        } else {
            return -1 * (int)number;
        }

    }
}