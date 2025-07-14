package BitManipulation.MediumProblems;
//Two numbers with odd occurrences
//        Difficulty: MediumAccuracy: 49.49%Submissions: 75K+Points: 4
//        Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.
//
//        Example 1:
//
//        Input:
//        N = 8
//        Arr = {4, 2, 4, 5, 2, 3, 3, 1}
//        Output: {5, 1}
//        Explanation: 5 and 1 have odd occurrences.
//
//        Example 2:
//
//        Input:
//        N = 8
//        Arr = {1 7 5 7 5 4 7 4}
//        Output: {7, 1}
//        Explanation: 7 and 1 have odd occurrences.
//
//        Your Task:
//        You don't need to read input or print anything. Your task is to complete the function twoOddNum() which takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order which have odd occurrences.
//
//
//        Expected Time Complexity: O(N)
//        Expected Auxiliary Space: O(1)
//
//
//        Constraints:
//        2 ≤ N ≤ 106
//        1 ≤ Arri ≤ 1012
public class FindTwoNumbersWIthOddOccurances {
    public int[] twoOddNum(int arr[], int N) {
        int xor = 0;
        for(int i=0; i<N; i++) {
            xor = xor ^ arr[i];
        }
        int bitInd = findFirstDiffBit(xor);

        int bucket0 = 0, bucket1 = 0;
        for(int i=0; i<N; i++) {
            if(((arr[i] >> bitInd) & 1) == 1) {
                bucket1 = bucket1 ^ arr[i];
            } else {
                bucket0 = bucket0 ^ arr[i];
            }
        }
        if(bucket0 > bucket1) return new int[]{bucket0, bucket1};
        return new int[]{bucket1, bucket0};
    }
    private int findFirstDiffBit(int n) {
        int count = 0;
        while((n & 1) != 1) {
            count++;
            n = n >> 1;
        }
        return count;
    }
}
