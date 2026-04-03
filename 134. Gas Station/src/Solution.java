class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;
        int i = 0;
        while (i < gas.length) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += (gas[i] - cost[i]);
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
            i++;
        }
        return totalGas < totalCost ? -1 : start;
    }
}