class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum must be mid or to its left
                right = mid;
            } else {
                // When nums[mid] == nums[right], we can't be sure where the pivot is.
                // Safely move the right pointer in by one to narrow the search.
                right--;
            }
        }

        return nums[left];
    }
}
