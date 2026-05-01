class Solution {
    public int maxArea(int[] height) {
        // set left and right pointers and calculate max area
        int minPointer = 0;
        int maxPointer = height.length - 1;
        int max_area = (maxPointer - minPointer) * Math.min(height[minPointer], height[maxPointer]);

        // loop whilst pointers are in valid positions
        while (minPointer < maxPointer) {
            if (height[minPointer] < height[maxPointer]) {
                // move left pointer to right
                minPointer++;
            } else {
                // move right pointer to left
                maxPointer--;
            }

            // calculate new area
            int new_area = (maxPointer - minPointer) * Math.min(height[minPointer], height[maxPointer]);

            if (new_area > max_area) {
                // only update if new area is bigger
                max_area = new_area;
            }
        }

        return max_area;
    }
}