package BitManipulation.MediumProblems;
//Find XOR of numbers from L to R. https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/0
//        Difficulty: EasyAccuracy: 50.0%Submissions: 61K+Points: 2Average Time: 10m
//        You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
//
//        Example:
//
//        Input:
//        L = 4, R = 8
//        Output:
//        8
//        Explanation:
//        4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
//        Your Task:
//
//        Your task is to complete the function findXOR() which takes two integers l and r and returns the XOR of numbers from l to r.
//
//        Expected Time Complexity: O(1).
//
//        Expected Auxiliary Space: O(1).
//
//        Constraints:
//
//        1<=l<=r<=109
public class FindXorOfNumbersFromLtoR {
    public int findXOR(int l, int r) {
        return xor(r) ^ xor(l-1);
    }
    private int xor(int n) {
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n+1;
        if(n % 4 == 3) return 0;
        return -1;
    }
}
