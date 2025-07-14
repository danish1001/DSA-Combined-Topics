package RecursionBacktracking;

import java.util.ArrayList;
import java.util.List;

public class BoardPath {
    public void printBoardPath(int target, String output) {
        if(target == 0) {
            System.out.println(output);
            return;
        }
        if(target < 0) return;

        for(int dice=1; dice<=6; dice++) {
            printBoardPath(target - dice, output + dice);
        }
    }
    public static void printBoardPath(int start, int end, String output) {
        if(start == end) {
            System.out.print(output + " ");
            return;
        } else if(start > end) {
            return;
        }
        for(int dice=1; dice<=6; dice++) {
            printBoardPath(start + dice, end, output + dice);
        }
    }

//    This is Different from above as this doesn't generate all possible Permutations (Unique).
    public void printBoardPath1(int target, String output, int[] count, int[] dice, int i, List<String> res) {
        if(target == 0) {
            count[0]++;
            res.add(output);
            System.out.println(output + " " + output.length());
            return;
        }
        if(target < 0 || i > 5) return;
        printBoardPath1(target-dice[i], output+dice[i], count, dice, i, res);
        printBoardPath1(target, output, count, dice, i+1, res);
    }

    public List<String> getPrintBoardPath(int target) {
        if(target == 0) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        } else if(target < 0) {
            List<String> baseRes = new ArrayList<>();
            return baseRes;
        }
        List<String> result = new ArrayList<>();
        for(int dice=1; dice<=6; dice++) {
            List<String> recursionRes = getPrintBoardPath(target-dice);
            for(String str: recursionRes) {
                result.add(str + dice);
            }
        }
        return result;
    }
}
