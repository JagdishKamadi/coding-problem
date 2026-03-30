class Solution2 {
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; // assuming lowercase letters

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}