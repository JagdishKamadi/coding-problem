class Solution {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
        return binarySearch(nums, 0, pivot - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}