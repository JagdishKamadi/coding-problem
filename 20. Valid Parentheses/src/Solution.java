import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                char peek = stack.peek();
                if (ch == ')' && peek == '(') {
                    stack.pop();
                } else if (ch == '}' && peek == '{') {
                    stack.pop();
                } else if (ch == ']' && peek == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}