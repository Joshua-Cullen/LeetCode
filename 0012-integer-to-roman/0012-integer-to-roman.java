class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String result = "";
        
        while (num != 0) {
            // loop through symbol values, trying to take away the largest one possible
            // continue until the number reaches 0
            int index = 0;
            while (num - values[index] < 0) {
                index++;
            }
            result += symbols[index];
            num -= values[index];
        }

        return result;
    }
}