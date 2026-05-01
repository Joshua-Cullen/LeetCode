class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[min] <= nums[mid]) {
                // left side is sorted
                if (nums[min] <= target && target <= nums[mid]) {
                    // target is in left side, which is sorted 
                    max = mid - 1; 
                } else {
                    // target is in right side, which could be unsorted
                    min = mid + 1;
                }
            } else {
                // right side is sorted
                if (nums[mid] <= target && target <= nums[max]) {
                    // target is in right side, which is sorted
                    min = mid + 1;
                } else {
                    // target is in left side, which could be unsorted
                    max = mid - 1;
                }
            }
        }
        return -1;
    }
}