import java.util.*;

class Solution {
    public ArrayList<Integer> topView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            Integer hd = currentPair.value;
            if (!treeMap.containsKey(hd)) {
                treeMap.put(hd, currentNode.data);
            }
            if (currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, hd + 1));
            }
        }
        return new ArrayList<>(treeMap.values());
    }

    private static class Pair {
        private Node node;
        private Integer value;

        public Pair(Node node, Integer value) {
            this.node = node;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(new Solution().topView(root));
    }

    private static Node buildTree() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);
        return root;
    }
}