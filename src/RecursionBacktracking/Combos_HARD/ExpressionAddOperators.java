package RecursionBacktracking.Combos_HARD;

import java.util.ArrayList;
import java.util.List;

//282. Expression Add Operators https://leetcode.com/problems/expression-add-operators/description/
//        Solved
//        Hard
//        Topics
//        Companies
//        Hint
//        Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
//
//        Note that operands in the returned expressions should not contain leading zeros.
//
//
//
//        Example 1:
//
//        Input: num = "123", target = 6
//        Output: ["1*2*3","1+2+3"]
//        Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
//        Example 2:
//
//        Input: num = "232", target = 8
//        Output: ["2*3+2","2+3*2"]
//        Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
//        Example 3:
//
//        Input: num = "3456237490", target = 9191
//        Output: []
//        Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
//
//
//        Constraints:
//
//        1 <= num.length <= 10
//        num consists of only digits.
//        -231 <= target <= 231 - 1
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve(num, 0, (long) target, "", res, 0, 0);
        return res;
    }
    private void solve(String digit, int index, long target, String out, List<String> res, long prev, long curr) {
        if(index == digit.length()) {
            if(curr == target) res.add(out);
            return;
        }
        String number = "";
        long num = 0;

        for(int i=index; i<digit.length(); i++) {
            if(i > index && digit.charAt(index) == '0') return;
            number += digit.charAt(i);
            num = num * 10 + (digit.charAt(i)-'0');

            if(index == 0) {
                solve(digit, i+1, target, number, res, num, num);
            } else {
                solve(digit, i+1, target, (out + "+" + number), res, num, curr + num);
                solve(digit, i+1, target, (out + "-" + number), res, -num, curr - num);
                solve(digit, i+1, target, (out + "*" + number), res, (prev*num), (curr-prev) + (prev*num));
            }
        }
    }
}
