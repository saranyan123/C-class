class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<int> st; // Stores indices
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use 0 height at the end to flush out all remaining bars in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // If current bar is shorter than the bar at stack top, we found a boundary
            while (!st.empty() && currentHeight < heights[st.top()]) {
                int h = heights[st.top()];
                st.pop();
                
                // Calculate width: if stack is empty, it means this bar was the shortest so far
                int w = st.empty() ? i : i - st.top() - 1;
                
                maxArea = max(maxArea, h * w);
            }
            st.push(i);
        }
        
        return maxArea;
    }
};
