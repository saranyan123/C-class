class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            // 'ones' holds bits that appeared once
            // 'twos' holds bits that appeared twice
            
            // Logic: A bit is added to 'ones' if it's not in 'twos'
            ones = (ones ^ num) & ~twos;
            
            // Logic: A bit is added to 'twos' if it's already in 'ones'
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}
