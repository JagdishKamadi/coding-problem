import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] result = new int[n][2];
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        int counter = 0;
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= result[counter][1]) {
                result[counter][1] = Math.max(intervals[i][1], result[counter][1]);
            } else {
                counter++;
                result[counter][0] = intervals[i][0];
                result[counter][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(result, counter + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = new Solution().merge(intervals);
        Arrays.stream(result)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}