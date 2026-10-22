class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        if (first == -1 || last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private int findFirst(int[] nums, int target) {
        int first = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }

    private int findLast(int[] nums, int target) {
        int last = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
    }
}
