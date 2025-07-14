package RecursionBacktracking.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
    public List<String> generateBinaryStrings_sol1(int n) {
        List<String> res = new ArrayList<>();
        solve(n, "", res);
        return res;
    }
    private void solve(int n, String out, List<String> res) {
        if(n == 0) {
            res.add(out);
            return;
        }
        if(!out.isEmpty() && out.charAt(out.length()-1) == '1') {
            solve(n-1, out + "0", res);
        } else {
            solve(n-1, out + "0", res);
            solve(n-1, out + "1", res);
        }
    }

    // -------------------------------------------------------------------------
    public static List<String> generateBinaryStrings_sol2(int n) {
        return solve(n);
    }

    private static List<String> solve(int n) {
        if(n == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        List<String> recResult = solve(n-1);
        List<String> result = new ArrayList<>();

        for(String s: recResult) {
            if(!s.isEmpty() && s.charAt(s.length()-1) == '1') {
                result.add(s + "0");
            } else {
                result.add(s + "0");
                result.add(s + "1");
            }
        }
        return result;
    }


}
