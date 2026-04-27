import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        
        int maxPoints = 1;
        
        for (int i = 0; i < n; i++) {
            // Map to store: Slope -> Count of points with that slope
            Map<Double, Integer> slopeCount = new HashMap<>();
            
            for (int j = i + 1; j < n; j++) {
                double slope = calculateSlope(points[i], points[j]);
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                maxPoints = Math.max(maxPoints, slopeCount.get(slope));
            }
        }
        
        return maxPoints;
    }

    private double calculateSlope(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        
        if (dx == 0) return Double.POSITIVE_INFINITY; // Vertical line
        if (dy == 0) return 0.0;                       // Horizontal line
        
        // Using double for slope. Note: double precision issues can occur 
        // in rare edge cases, but for LeetCode constraints, this works.
        return (double) dy / dx;
    }
}
