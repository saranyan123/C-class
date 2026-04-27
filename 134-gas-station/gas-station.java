class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

            // If current tank drops below 0, station 'i' cannot be reached.
            // Therefore, no station from 'startIndex' to 'i' can be the start.
            if (currentTank < 0) {
                // Try starting from the next station
                startIndex = i + 1;
                // Reset the tank for the new starting point
                currentTank = 0;
            }
        }

        // If total gas is less than total cost, a circuit is impossible
        return (totalGas < totalCost) ? -1 : startIndex;
    }
}
