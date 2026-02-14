import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] nums = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(new Solution().findMissingAndRepeatedValues(nums)));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] freq = new int[m * n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }
        int repeat = -1;
        int missing = -1;

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                repeat = i;
            }
            if (freq[i] == 0) {
                missing = i;
            }
        }
        return new int[]{repeat, missing};
    }
}