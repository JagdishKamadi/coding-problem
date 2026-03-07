import java.util.Arrays;

class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }
            chars[index++] = currentChar;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = new Solution().compress(ch);
        System.out.println(Arrays.toString(Arrays.copyOf(ch, len)));
    }
}