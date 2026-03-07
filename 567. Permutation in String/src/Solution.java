import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length > s2Length) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        int i = 0;
        int left = 0;
        for (; i < s1Length; i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (s1Map.equals(s2Map)) {
            return true;
        }
        for (; i < s2Length; i++) {
            char rightChar = s2.charAt(i);
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);
            char leftChar = s2.charAt(left);
            s2Map.put(leftChar, s2Map.get(leftChar) - 1);
            if (s2Map.get(leftChar) == 0) {
                s2Map.remove(leftChar);
            }
            left++;
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "ccbcaa";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }
}