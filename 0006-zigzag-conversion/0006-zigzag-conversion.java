class Solution {
    public String convert(String s, int numRows) {
        // stores a string for each row
        String[] rows = new String[numRows];
        int currentIndex = 0;
        boolean stop = false;

        while (!stop) {
            // loop through next numRows characters in string, adding each char to each row string 
            for (int index = 0; index < numRows; index++) {
                if (currentIndex >= s.length()) {
                    // reached end of string, stop execution
                    stop = true;
                    break;
                }

                // add the character to the relevant row
                String c = s.substring(currentIndex, currentIndex + 1);
                if (rows[index] == null) {
                    rows[index] = c;
                } else {
                    rows[index] += c;
                }

                currentIndex++;
            }

            if (!stop) {
                // only continue if not reached end of string, now add diagonal
                for (int index = numRows - 2; index > 0; index--) {
                    if (currentIndex >= s.length()) {
                        stop = true;
                        break;
                    }

                    // add the character the relevant row
                    rows[index] += s.substring(currentIndex, currentIndex + 1);
                    currentIndex++;
                }
            }
        }

        // now concat all rows together to get result
        String result = "";
        for (String row : rows) {
            if (row != null) {
                // ignore any rows which are still null
                result += row;
            }
        }

        return result;
    }
}