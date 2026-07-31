import java.util.Arrays;

public class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return;
        }
        int lastIndex = -1;
        int i = 1;
        while (i < n) {
            if (arr[i - 1] < arr[i]) {
                lastIndex = i;
            }
            i++;
        }

        // lastIndex=-1, means There is no increasing pair.
        if (lastIndex == -1) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                swap(arr, left++, right--);
            }
            return;
        }

        int index = lastIndex;
        for (i = lastIndex; i < n; i++) {
            if (arr[i] > arr[lastIndex - 1] && arr[i] < arr[index]) {
                index = i;
            }
        }
        swap(arr, lastIndex - 1, index);
        Arrays.sort(arr, lastIndex, n);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2}; // 14235
        new Solution().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
