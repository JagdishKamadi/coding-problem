class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;

        if (size == 0) {
            return;
        }

        k = k % size;

        int[] firstPart = new int[k];

        for (int i = 0; i < k; i++) {
            firstPart[i] = nums[size - k + i];
        }

        int[] secondPart = new int[size - k];

        int start = 0;
        for (int i = 0; i < size - k; i++) {
            secondPart[start++] = nums[i];
        }

        int length = firstPart.length;

        for (int i = 0; i < length; i++) {
            nums[i] = firstPart[i];
        }

        for (int i = 0; i < secondPart.length; i++) {
            nums[i + length] = secondPart[i];
        }
    }
}