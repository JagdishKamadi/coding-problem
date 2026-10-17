class BruteForceSolution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long product = 1;
            for (int j = i; j >= 0; j--) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        System.out.println(new BruteForceSolution().numSubarrayProductLessThanK(arr, 100));
    }
}