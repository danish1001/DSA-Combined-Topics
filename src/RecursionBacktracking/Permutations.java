package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public void printPermutations(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
        }

        for(int i=0; i<input.length(); i++) {
            char fixed = input.charAt(i);
            String remaining = input.substring(0, i) + input.substring(i+1);
            printPermutations(remaining, fixed + output);
        }
    }

    public List<String> getPermutations(String input) {
        if(input.isEmpty()) {
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char fixed = input.charAt(0);
        String remaining = input.substring(1);

        List<String> recursionResult = getPermutations(remaining);
        List<String> result = new ArrayList<>();

        for(String str: recursionResult) {
            for(int j=0; j<=str.length(); j++) {
                String newStr = str.substring(0,j) + fixed + str.substring(j);
                result.add(newStr);
            }
        }
        return result;
    }

    public void printPermutationWithSpaces(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char space = '_';
        char ch = input.charAt(0);
        String remaining = input.substring(1);

        printPermutationWithSpaces(remaining,output + space + ch);
        printPermutationWithSpaces(remaining, output + ch);
    }

    public void printPermutationWithCaseChange(String input, String output) {
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        String remaining = input.substring(1);

        printPermutationWithCaseChange(remaining, output + Character.toUpperCase(ch));
        printPermutationWithCaseChange(remaining, output + ch);
    }
}
