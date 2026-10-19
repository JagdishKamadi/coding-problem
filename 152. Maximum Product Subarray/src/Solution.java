class Solution {
    public int maxProduct(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = nums[0];
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            // calculate product
            leftProduct *= nums[i];
            rightProduct *= nums[size - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
}