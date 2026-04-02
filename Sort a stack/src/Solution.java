import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        List<Integer> lst = new ArrayList<>();
        while (!st.isEmpty()) {
            lst.add(st.pop());
        }
        Collections.sort(lst);
        for (int i : lst) {
            st.push(i);
        }
    }
}