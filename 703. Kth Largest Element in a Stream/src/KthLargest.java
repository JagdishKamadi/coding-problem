import java.util.PriorityQueue;

class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int num : nums) {
            addToHeap(num);
        }
    }

    public int add(int val) {
        addToHeap(val);
        return pq.peek();
    }

    private void addToHeap(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(-1);
        queue.add(7);
        queue.add(5);
        System.out.println(queue);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */