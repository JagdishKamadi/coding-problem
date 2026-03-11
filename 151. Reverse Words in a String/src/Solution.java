class Solution {
    public String reverseWords(String s) {
        String[] split = s.strip().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = split.length - 1;
        for (; i > 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        sb.append(split[i]);
        return sb.toString();
    }
}