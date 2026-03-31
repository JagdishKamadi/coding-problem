import java.util.Stack;

public class MinStack {
    private final Stack<ValMinPair> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new ValMinPair(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    private static record ValMinPair(int val, int min) {

    }
}
