class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";

        // loop through each char in string, treating as the mid point of the palindrome
        for (int index = 0; index < s.length(); index++) {
            // check for odd length palindromes
            String largestOddPalindrome = findPalindrome(s, index, index);
            // check for even length palindromes
            String largestEvenPalindrome = findPalindrome(s, index, index+1);

            // replace longestPalindrome if one of the palindromes found are longer
            if (largestEvenPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = largestEvenPalindrome;
            } else if (largestOddPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = largestOddPalindrome;
            }
        }

        return longestPalindrome;
    }

    private String findPalindrome(String s, int left, int right) {
        Boolean stop = false;
        // continue whilst pointers are valid and should not stop (last 2 chars matched)
        while (left >= 0 && right < s.length() && !stop) {
            stop = (s.charAt(left) != s.charAt(right));

            if (!stop) {
                // update pointers if there will be another iteration
                left--;
                right++;    
            }
        }

        // return the palindrome
        return s.substring(left+1, right);
    }
}