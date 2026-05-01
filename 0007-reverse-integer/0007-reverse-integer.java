class Solution {
    public int reverse(int x) {
        if (x >= 0) {
            try {
                // reverse the string and convert to an integer
                return Integer.parseInt(reverseString(Integer.toString(x)));
            } catch (Exception e) {
                return 0;
            }
        } else {
            // is negative, so need to add - sign to front
            try {
                return Integer.parseInt("-" + reverseString(Integer.toString(x).substring(1)));
            } catch (Exception e) {
                return 0;
            }
        }
    }

    private String reverseString(String str) {
        String newStr = "";
        for (int index = str.length() - 1; index >= 0; index--) {
            newStr += str.substring(index, index + 1);
        }

        return newStr;
    }
}