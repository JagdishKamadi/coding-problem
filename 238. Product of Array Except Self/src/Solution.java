class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < n; i++) {
            res[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return res;
    }
}