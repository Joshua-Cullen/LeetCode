class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // store the numbers sorted
        ArrayList<Integer> numsSorted = new ArrayList<>();
        for (int num : nums) {
            numsSorted.add(num);
        }
        numsSorted.sort(Integer::compare);
        
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int x = 0; x < nums.length-1; x++) {
            int numX = numsSorted.get(x);
            int left = x+1;
            int right = nums.length-1;

            // move pointers to get the closest 3sum
            while (left != right) {
                int sum = numX + numsSorted.get(left) + numsSorted.get(right);

                if (Math.abs(sum-target) < Math.abs(closestSum-target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    // found target, cannot get any closer
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}