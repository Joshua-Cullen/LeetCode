class Solution {
    enum State {
        WHITESPACE,SIGN,LEADINGZEROS,NUMBER
    }

    public int myAtoi(String s) {
        State state = State.WHITESPACE;
        int negative = 0;
        String num = "";

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            switch (state) {
                case State.WHITESPACE:
                    // continue to process whitespace until find a character other than ' '
                    if (c != ' ') {
                        state = State.SIGN;
                        index--;
                    }
                    break;

                case State.SIGN:
                    // process the sign (if one exists) and set negative to represent the sign
                    if (c == '-' && negative == 0) {
                        negative = -1;
                    } else if (c == '+' && negative == 0) {
                        negative = 1;
                    } else if (c != '-' && negative == 0) {
                        negative = 1;
                        index--;
                    } else {
                        state = State.LEADINGZEROS;
                        index--;
                    }
                    break;

                case State.LEADINGZEROS:
                    // process leading zeros until no more exist 
                    if (c != '0') {
                        state = State.NUMBER;
                        index--;
                    }
                    break;

                case State.NUMBER:
                    // process the number 
                    if (Character.isDigit(c)) {
                        num += c;
                    }

                    if (!Character.isDigit(c) || index == s.length() - 1) {
                        // reached the end of the number, need to process the number now 
                        if (num == "") {
                            return 0;
                        }

                        long result;
                        long bound = (long) Math.pow(2,31);
                        try {
                            result = Integer.parseInt(num) * negative;
                        } catch (Exception e) {
                            if (negative == -1) {
                                result = -bound;
                            } else {
                                result = bound - 1;
                            }
                        }

                        return (int) result;
                    }
                    break;
            }
        }

        return 0;
    }
}