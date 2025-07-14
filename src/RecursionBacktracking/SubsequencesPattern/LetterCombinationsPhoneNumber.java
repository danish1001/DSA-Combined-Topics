package RecursionBacktracking.SubsequencesPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//17. Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//        Solved
//        Medium
//        Topics
//        Companies
//        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//
//        Example 1:
//
//        Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//
//        Input: digits = ""
//        Output: []
//        Example 3:
//
//        Input: digits = "2"
//        Output: ["a","b","c"]
//
//
//        Constraints:
//
//        0 <= digits.length <= 4
//        digits[i] is a digit in the range ['2', '9'].
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");;
        List<String> res = new ArrayList<>();
        multiply(digits, res, map, "");
        return res;
    }
    public void multiply(String digits, List<String> res, Map<Character, String> map, String out) {
        if(digits.isEmpty()) {
            if(!out.isEmpty()) res.add(out);
            return;
        }
        String first = map.get(digits.charAt(0));
        for(int i=0; i<first.length(); i++) {
            multiply(digits.substring(1), res, map, out + first.charAt(i));
        }
    }
}
