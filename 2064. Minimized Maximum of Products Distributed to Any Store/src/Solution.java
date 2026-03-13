class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxQuantity = 0;
        for (int q : quantities) {
            maxQuantity = Math.max(maxQuantity, q);
        }

        int left = 1;
        int right = maxQuantity;
        int result = maxQuantity;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int requiredStores = canAssign(quantities, mid);
            if (requiredStores <= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int canAssign(int[] quantities, int maxPerStore) {
        int stores = 0;
        for (int q : quantities)
            stores += (q + maxPerStore - 1) / maxPerStore;
        return stores;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] quantities = {15, 10, 10};
        System.out.println(new Solution().minimizedMaximum(n, quantities));
    }
}