package RecursionBacktracking.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(2*n-1, "(", 1, 0, res);
        return res;
    }
    public void solve(int n, String output, int open, int close, List<String> res) {
        if(n == 0 && open == close) {
            res.add(output);
            return;
        }
        if(n == 0) return;

        if(open == close) {
            solve(n-1, output + "(", open + 1, close, res);
        } else if(open > close) {
            solve(n-1, output + "(", open + 1, close, res);
            solve(n-1, output + ")", open, close + 1, res);
        } else {
            return;
        }
    }
}