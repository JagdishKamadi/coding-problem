class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;   // move to increasing side
            } else {
                right = mid;      // peak is at mid or left side
            }
        }
        return left;
    }
}