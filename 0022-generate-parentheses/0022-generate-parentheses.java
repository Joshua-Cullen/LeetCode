class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        if (n == 0) {
            return results;
        }

        backtrack(n, 0, 0, new StringBuilder(), results);
        return results;
    }

    private void backtrack(int max, int openCount, int closedCount, StringBuilder currentPath, List<String> results) {
        if (currentPath.length() == max * 2) {
            // reached max length, add to results
            results.add(currentPath.toString());
            return;
        }

        if (openCount < max) {
            // can add another open bracket
            currentPath.append("(");
            backtrack(max, openCount + 1, closedCount, currentPath, results);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }

        if (closedCount < openCount) {
            // can add a closed bracket
            currentPath.append(")");
            backtrack(max, openCount, closedCount + 1, currentPath, results);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}