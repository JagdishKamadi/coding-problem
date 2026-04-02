import java.util.Stack;

public class Solution2 {
    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        insertSortedElement(st, top);
    }

    public void insertSortedElement(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertSortedElement(stack, value);
        stack.push(top);
    }
}