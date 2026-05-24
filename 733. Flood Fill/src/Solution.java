import java.util.Arrays;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        int[][] result = new int[image.length][];
        for (int i = 0; i < image.length; i++) {
            result[i] = image[i].clone();
        }

        floodFillHelper(result, sr, sc, color, originalColor);
        return result;
    }

    private void floodFillHelper(int[][] result, int sr, int sc, int targetColor, int originalColor) {
        if (sr < 0 || sr >= result.length || sc < 0 || sc >= result[0].length) {
            return;
        }

        if (result[sr][sc] != originalColor) {
            return;
        }

        result[sr][sc] = targetColor;

        floodFillHelper(result, sr - 1, sc, targetColor, originalColor); // up
        floodFillHelper(result, sr + 1, sc, targetColor, originalColor); // down
        floodFillHelper(result, sr, sc - 1, targetColor, originalColor); // left
        floodFillHelper(result, sr, sc + 1, targetColor, originalColor); // right
    }
}