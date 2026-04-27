import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Every child must have at least one candy
        Arrays.fill(candies, 1);
        
        // Left-to-right pass: satisfy left neighbor requirement
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right-to-left pass: satisfy right neighbor requirement
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Take the max to ensure both neighbor constraints are met
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Sum total candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}
