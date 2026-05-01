class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // store the numbers sorted
        ArrayList<Integer> numsSorted = new ArrayList<>();
        for (int num : nums) {
            numsSorted.add(num);
        }
        numsSorted.sort(Integer::compare);

        // fix first and second num using pointers to get the final two nums
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a != 0 && numsSorted.get(a-1).equals(numsSorted.get(a))) {
                continue;
            }
            for (int b = a + 1; b < nums.length-1; b++) {
                if (b != a + 1 && numsSorted.get(b-1).equals(numsSorted.get(b))) {
                    continue;
                }

                int left = b + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) numsSorted.get(a) + numsSorted.get(b) + numsSorted.get(left) + numsSorted.get(right);
                    if (sum == target) {
                        // found quadruplet
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numsSorted.get(a));
                        list.add(numsSorted.get(b));
                        list.add(numsSorted.get(left));
                        list.add(numsSorted.get(right));        
                        result.add(list);

                        // update pointers
                        left++;
                        right--;
                        
                        while (left < right && numsSorted.get(left).equals(numsSorted.get(left-1))) {
                            left++;
                        } 
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}