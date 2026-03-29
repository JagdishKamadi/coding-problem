import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int counter = 0;
        for (int i : nums1) {
            Integer value = map.get(i);
            if (value != null) {
                for (int j = value+1; j < nums2.length; j++) {
                    if (nums2[j] > i) {
                        res[counter] = nums2[j];
                        break;
                    }
                }
            }
            counter++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4}, nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));
    }
}