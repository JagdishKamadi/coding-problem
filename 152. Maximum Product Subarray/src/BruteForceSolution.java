class BruteForceSolution {
    public int maxProduct(int[] nums) {
        int product = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = i; j >= 0; j--) {
                currentProduct *= nums[j];
                if (currentProduct > product) {
                    product = currentProduct;
                }
            }
        }
        return product;
    }
}