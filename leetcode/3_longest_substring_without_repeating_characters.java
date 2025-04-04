// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=aqw21527


// Solution 1, return 'Time Limit Exceeded 201 / 987 testcases passed'
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_len = s.length();
        Set<Character> hsc = new HashSet<Character>();
        for (int i=0;i<s.length();i++){
            if (hsc.contains(s.charAt(i))) {
                max_len = 0;
                break;
            } else {
                hsc.add(s.charAt(i));
            }
        }
        if (s.length() > 1) {
            int left_max_len = lengthOfLongestSubstring(s.substring(1));
            left_max_len = Math.max(1, left_max_len);
            max_len = Math.max(max_len, left_max_len);
            int right_max_len = lengthOfLongestSubstring(s.substring(0, s.length()-1));
            right_max_len = Math.max(1, right_max_len);
            max_len = Math.max(max_len, right_max_len);
        }
        return max_len;
    }
}

// Solution 2, return 'Time Limit Exceeded 199 / 987 testcases passed'
class Solution {
    private Set<Character> hsc = new HashSet<Character>();

    private int lengthOfLongestSubstring(String s, int start, int end) {
        hsc.clear();
        int len =  end - start;
        int max_len = len;
        for (int i=start;i<end;i++){
            if (hsc.contains(s.charAt(i))) {
                max_len = 0;
                break;
            } else {
                hsc.add(s.charAt(i));
            }
        }
        if (len > 1) {
            int left_max_len = lengthOfLongestSubstring(s, start +1, end);
            left_max_len = Math.max(1, left_max_len);
            max_len = Math.max(max_len, left_max_len);
            int right_max_len = lengthOfLongestSubstring(s, start, end-1);
            right_max_len = Math.max(1, right_max_len);
            max_len = Math.max(max_len, right_max_len);
        }
        return max_len;
    }

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s, 0, s.length());
    }
}

// Solution 3, return 'Time Limit Exceeded 211 / 987 testcases passed'
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max_len = s.length();
        if (max_len<=0) {
            return 0;
        }

        char [] arr = s.toCharArray();
        Arrays.sort(arr);

        char last = arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]==last){
                max_len = 0;
            } else {
                last = arr[i];
            }
        }
    
        if (s.length() > 1) {
            int left_max_len = lengthOfLongestSubstring(s.substring(1));
            left_max_len = Math.max(1, left_max_len);
            max_len = Math.max(max_len, left_max_len);
            int right_max_len = lengthOfLongestSubstring(s.substring(0, s.length()-1));
            right_max_len = Math.max(1, right_max_len);
            max_len = Math.max(max_len, right_max_len);
        }
        return max_len;
    }
}

// Solution 4, return 'Time Limit Exceeded 217 / 987 testcases passed'
class Solution {
    private int lengthOfLongestSubstring(char[] array, int start, int end) {
        int len = end - start;
        if(len<=0) {
            return 0;
        }

        char[] sub_array = Arrays.copyOfRange(array, start, end);
        int max = sub_array.length;

        Arrays.sort(sub_array);
        char last = sub_array[0];
        for (int i=1;i<sub_array.length;i++){
            if (last == sub_array[i]) {
                max = 0;
                break;
            } else {
                last = sub_array[i];
            }
        }

        if (len > 1) {
            int left_max = lengthOfLongestSubstring(array, start, end-1);
            int right_max = lengthOfLongestSubstring(array, start+1, end);
            max = Math.max(max, left_max);
            max = Math.max(max, right_max);
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s.toCharArray(), 0, s.length());
    }
}

// Solution 5, return 'Time Limit Exceeded 200 / 987 testcases passed'
class Solution {
    private Set<Character> hsc = new HashSet<Character>();
    private int lengthOfLongestSubstring(char[] array, int start, int end) {
        int len = end - start;
        if(len<=0) {
            return 0;
        }

        int max = len;
        hsc.clear();
        for (int i=start;i<end;i++) {
            if (hsc.contains(array[i])) {
                max = 0;
                break;
            } else {
                hsc.add(array[i]);
            }
        }

        if (len > 1) {
            int left_max = lengthOfLongestSubstring(array, start, end-1);
            int right_max = lengthOfLongestSubstring(array, start+1, end);
            max = Math.max(max, left_max);
            max = Math.max(max, right_max);
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s.toCharArray(), 0, s.length());
    }
}

// Solution 6, return 'Time Limit Exceeded 208 / 987 testcases passed'
class Solution {
    private char[] sub_array;
    private int lengthOfLongestSubstring(char[] array, int start, int end) {
        int len = end - start;
        if(len<=0) {
            return 0;
        }

        System.arraycopy(array, start, sub_array, 0, len);
        int max = len;

        Arrays.sort(sub_array);
        char last = sub_array[0];
        for (int i=1;i<len;i++){
            if (last == sub_array[i]) {
                max = 0;
                break;
            } else {
                last = sub_array[i];
            }
        }

        if (len > 1) {
            int left_max = lengthOfLongestSubstring(array, start, end-1);
            int right_max = lengthOfLongestSubstring(array, start+1, end);
            max = Math.max(max, left_max);
            max = Math.max(max, right_max);
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        sub_array = new char[s.length()];
        return lengthOfLongestSubstring(s.toCharArray(), 0, s.length());
    }
}

// Solution 7, 'Time Limit Exceeded 986 / 987 testcases passed'
class Solution {
    private int max(String s, int start, int end){
        Set<Character> hsc = new HashSet<Character>();
        for (int i=start;i<end;i++){
            char c = s.charAt(i);
            if (hsc.contains(c)) {
                return 0;
            } else {
                hsc.add(c);
            }
        }
        return end - start;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                int local_max = max(s, j, s.length());
                max = Math.max(max, local_max);
            }
            for (int j=s.length();j>=0;j--){
                int local_max = max(s, i, j);
                max = Math.max(max, local_max);
            }
        }

        for (int i=s.length();i>=0;i--){
            for (int j=0;j<i;j++){
                int local_max = max(s, j, i);
                max = Math.max(max, local_max);
            }
            for (int j=i;j>=0;j--){
                int local_max = max(s, 0, j);
                max = Math.max(max, local_max);
            }
        }

        return max;
    }
}
