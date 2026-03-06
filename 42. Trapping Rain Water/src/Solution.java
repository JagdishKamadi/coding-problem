class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        leftArr[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], height[i]);
        }
        rightArr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1], height[i]);
        }
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftArr[i], rightArr[i]) - height[i];
            totalWater += min;
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}