import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currentLongestSubstringLength = 0;

        // loop through each character in the string, finding the longest substring starting at each character
        for (int index = 0; index < s.length(); index++) {
            // find longest substring starting at index
            ArrayList<Character> currentSubstring = new ArrayList();
            int substringIndex = index;

            char currentChar;
            boolean stop = false;
            // continue until reached end of string or found a repeated char
            while (!stop && substringIndex < s.length()) {
                currentChar = s.charAt(substringIndex);
                stop = currentSubstring.contains(currentChar);
                
                if (!stop) {
                    currentSubstring.add(currentChar);
                }

                substringIndex++;
            }

            // if the new substring is longer than the current longest one, then replace
            if (currentSubstring.size() > currentLongestSubstringLength) {
                currentLongestSubstringLength = currentSubstring.size();
            } 
        }

        return currentLongestSubstringLength;
    }
}