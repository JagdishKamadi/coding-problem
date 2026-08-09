class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < n && heights[right] >= heights[i]) {
                right++;
            }
            int area = (right - left - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}