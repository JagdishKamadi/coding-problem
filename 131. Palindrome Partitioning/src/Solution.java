import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generatePartitions(s, new ArrayList<>(), result);
        return result;
    }

    private void generatePartitions(String str, List<String> partitions, List<List<String>> result) {
        if (str.isEmpty()) {
            result.add(new ArrayList<>(partitions));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String firstPartOfPartitions = str.substring(0, i + 1);
            if (isPalindrome(firstPartOfPartitions)) {
                partitions.add(firstPartOfPartitions);
                generatePartitions(str.substring(i + 1), partitions, result);
                partitions.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}