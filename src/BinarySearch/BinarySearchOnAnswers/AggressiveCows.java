package BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;

// Aggressive Cows https://www.naukri.com/code360/problems/aggressive-cows_1082559
//         Moderate
//         72/80
//         Average time to solve is 30m
//         Contributed by
//         984 upvotes
//         Asked in companies
//         Problem statement
//         You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.
//
//
//
//         You are also given an integer 'k' which denotes the number of aggressive cows.
//
//
//
//         You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//
//
//
//         Print the maximum possible minimum distance.
//
//
//
//         Example:
//         Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}
//
//         Output: 2
//
//         Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
//         Detailed explanation ( Input/output format, Notes, Images )
//         Sample Input 1 :
//         6 4
//         0 3 4 7 10 9
//
//
//         Sample Output 1 :
//         3
//
//
//         Explanation to Sample Input 1 :
//         The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.
//
//
//         Sample Input 2 :
//         5 2
//         4 2 1 3 6
//
//
//         Sample Output 2 :
//         5
//
//
//         Expected time complexity:
//         Can you solve this in O(n * log(n)) time complexity?
//
//
//         Constraints :
//         2 <= 'n' <= 10 ^ 5
//         2 <= 'k' <= n
//         0 <= 'arr[i]' <= 10 ^ 9
//         Time Limit: 1 sec.
public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 0, high = stalls[n-1];
        int res = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isValid(stalls, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
    private static boolean isValid(int[] stalls, int kCows, int minDistance) {
        int cows = 1;
        int prevLoc = stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i]-prevLoc >= minDistance) {
                prevLoc = stalls[i];
                cows++;
            }
        }
        if(cows >= kCows) return true;
        return false;
    }
}
