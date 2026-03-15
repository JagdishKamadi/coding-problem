import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombination(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void generateCombination(int[] candidates, int index, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }

        comb.add(candidates[index]);
        generateCombination(candidates, index, target - candidates[index], comb, result);
        comb.removeLast();
        generateCombination(candidates, index + 1, target, comb, result);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
    }
}
