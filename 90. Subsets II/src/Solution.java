import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, result);
            currentSubset.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}