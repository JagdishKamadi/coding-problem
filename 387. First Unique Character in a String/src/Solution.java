import java.util.stream.IntStream;

class Solution {
    public int firstUniqChar(String s) {
        return IntStream.range(0, s.length())
                .filter(i -> s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                .findFirst()
                .orElse(-1);
    }
}