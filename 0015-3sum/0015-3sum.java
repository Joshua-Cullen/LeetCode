class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int num : nums) {
            Integer occurences = numbers.get(num);
            if (occurences == null) {
                numbers.put(num, 1);
            } else {
                numbers.put(num, occurences + 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> alreadyStored = new HashSet<>();
        for (int x = 0; x < nums.length; x++) {
            for (int y = x+1; y < nums.length; y++) {
                int zNum = -nums[x] - nums[y];
                Integer zNumOccurences = numbers.get(zNum);

                if (zNumOccurences == null) {
                    continue;
                }

                if (zNum == nums[x]) {
                    zNumOccurences--;
                }
                if (zNum == nums[y]) {
                    zNumOccurences--;
                }

                if (zNumOccurences >= 1) {
                    // found valid triplet
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[x]);
                    list.add(nums[y]);
                    list.add(zNum);
                    list.sort(Integer::compare);

                    if (!alreadyStored.contains(list)) {
                        // not already stored
                        alreadyStored.add(list);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}