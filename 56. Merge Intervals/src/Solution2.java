import java.util.Arrays;
import java.util.Comparator;

class Solution2 {
    public int[][] merge(int[][] intervals) {
        int count = 0;
        int n = intervals.length;
        int[][] res = new int[n][2];
        // sort the interval array based on starting point itself which intervals[i][0]
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= res[count][1]) {
                res[count][1] = Math.max(res[count][1], intervals[i][1]);
            } else {
                count++;
                res[count][0] = intervals[i][0];
                res[count][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(res, count + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{4, 7}, {1, 4}};
        int[][] result = new Solution2().merge(intervals);
        Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}