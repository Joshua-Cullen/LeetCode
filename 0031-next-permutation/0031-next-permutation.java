class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index+1]) {
            index--;
        }

        if (index == -1) {
            // nums is in descending order, last permutation
            Arrays.sort(nums);
        } else {
            int left = index;
            int right = nums.length - 1;

            while (right > left && nums[left] >= nums[right]) {
                right--;
            }

            //swap pointers 
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            //reverse subarray right of left pointer
            reverseSubArray(left+1, nums);
        }
    }

    public void reverseSubArray(int start, int[] nums) {
        int end = nums.length - 1;
        while (start < end) {
            // swap
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}