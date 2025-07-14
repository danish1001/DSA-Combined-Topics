package RecursionBacktracking.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public void printSubsequences(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char cc = input.charAt(0);
        String remaning = input.substring(1);

        printSubsequences(remaning, output + cc);
        printSubsequences(remaning, output);
    }

    public List<String> getSubsequences(String input) {
        if(input.isEmpty()) {
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char ch = input.charAt(0);
        String remaining = input.substring(1);

        List<String> recursionResult = getSubsequences(remaining);
        List<String> result = new ArrayList<>();
        for(String str: recursionResult) {
            result.add(ch + str);
            result.add(str);
        }
        return result;
    }
}
