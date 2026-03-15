import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombination(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void generateCombination(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // stop if the number is greater than remaining target
            if (candidates[i] > target) {
                return;
            }
            comb.add(candidates[i]);
            generateCombination(candidates, i + 1, target - candidates[i], comb, result);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}