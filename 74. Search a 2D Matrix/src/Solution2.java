class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][matrix[0].length - 1]) {
                start = mid + 1;
            } else {
                int left = 0;
                int right = matrix[mid].length - 1;
                while (left <= right) {
                    int m = left + (right - left) / 2;
                    if (matrix[mid][m] == target) {
                        return true;
                    } else if (target < matrix[mid][m]) {
                        right = m - 1;
                    } else {
                        left = m + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(new Solution2().searchMatrix(matrix, 11));
    }
}