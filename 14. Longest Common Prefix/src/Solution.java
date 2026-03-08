import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        String startString = strs[0];
        String endString = strs[strs.length - 1];
        for (int i = 0; i < Math.min(startString.length(), endString.length()); i++) {
            if (startString.charAt(i) != endString.charAt(i)) {
                return sb.toString();
            }
            sb.append(startString.charAt(i));
        }
        return sb.toString();
    }
}