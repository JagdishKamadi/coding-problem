import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);
            while (basket.size() > 2) {
                Integer firstFruitCount = basket.get(fruits[left]);
                if (firstFruitCount == 1) {
                    basket.remove(fruits[left]);
                } else {
                    basket.put(fruits[left], firstFruitCount - 1);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}