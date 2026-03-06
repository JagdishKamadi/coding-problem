import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.strip().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}