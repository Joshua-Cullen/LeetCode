class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] results = {-1, -1};

        results[0] = getBound(nums, target, true); // get lower bound
        results[1] = getBound(nums, target, false); // get upper bound

        return results;
    }

    private int getBound(int[] nums, int target, boolean leftBound) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (leftBound) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return bound;
    }
}