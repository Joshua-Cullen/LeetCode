class Solution {
    // create a map converting a digit to the possible letters
    private Map<Character, char[]> numToLetter = Map.of(
            '2', new char[] {'a','b','c'},
            '3', new char[] {'d','e','f'},
            '4', new char[] {'g','h','i'},
            '5', new char[] {'j','k','l'},
            '6', new char[] {'m','n','o'},
            '7', new char[] {'p','q','r','s'},
            '8', new char[] {'t','u','v'},
            '9', new char[] {'w','x','y','z'}
    );

    public List<String> letterCombinations(String digits) {
        // create list to store all possible combinations 
        List<String> result = new ArrayList<>();

        if (digits == "") {
            // return an empty list if digits is empty
            return result;
        }

        backtrack(digits, 0, new StringBuilder(4), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentPath, List<String> result) {
        if (index >= digits.length()) {
            // reached end of path, backtrack up path adding results
            result.add(currentPath.toString());
            return;
        }

        // get current digit and possible letters
        char currentDigit = digits.charAt(index);
        char[] possibleLetters = numToLetter.get(currentDigit);

        for (char letter : possibleLetters) {
            // select this path
            currentPath.append(letter);
            // continue further down this path
            backtrack(digits, index + 1, currentPath, result);
            // remove character and try different path
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}