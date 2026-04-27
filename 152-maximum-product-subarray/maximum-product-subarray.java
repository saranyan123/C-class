class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Initialize with the first element
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = maxSoFar;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // If the current number is negative, swapping max and min 
            // is necessary because max * negative = min, and min * negative = max.
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // The new max/min is either the current number alone 
            // or the current number multiplied by the previous max/min.
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update the global maximum found so far
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
