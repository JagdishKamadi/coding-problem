class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        while (c1 < m && c2 < n) {
            if (nums1[c1] < nums2[c2]) {
                nums[c3++] = nums1[c1++];
            } else {
                nums[c3++] = nums2[c2++];
            }
        }

        while (c1 < m) {
            nums[c3++] = nums1[c1++];
        }
        while (c2 < n) {
            nums[c3++] = nums2[c2++];
        }

        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
    }
}