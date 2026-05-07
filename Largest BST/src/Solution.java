class Solution {
    static int largestBst(Node root) {
        return largestBSTHelper(root).size;
    }

    private static Info largestBSTHelper(Node root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info left = largestBSTHelper(root.left);
        Info right = largestBSTHelper(root.right);

        if (root.data > left.max && root.data < right.min) {
            int currentMin = Math.min(root.data, left.min);
            int currentMax = Math.max(root.data, right.max);
            int currentSize = left.size + right.size + 1;
            return new Info(currentMin, currentMax, currentSize);
        }
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    private record Info(int min, int max, int size) {
    }
}