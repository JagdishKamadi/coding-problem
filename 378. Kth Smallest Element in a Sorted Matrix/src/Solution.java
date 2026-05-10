import java.util.Arrays;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .skip((long) k - 1)
                .findFirst()
                .orElseThrow();
    }
}