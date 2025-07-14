package BinarySearch.BinarySearchOn2DArrays;

import java.util.Comparator;
import java.util.PriorityQueue;

//Median in a row-wise sorted Matrix https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
//        Difficulty: HardAccuracy: 55.05%Submissions: 138K+Points: 8
//        Given a row-wise sorted matrix where the number of rows and columns is always odd, find the median of the matrix.
//
//        Examples:
//
//        Input: mat = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
//        Output: 5
//        Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median.
//        Input: mat = [[1], [2], [3]]
//        Output: 2
//        Explanation: Sorting matrix elements gives us {1,2,3}. Hence, 2 is median
//        Input: mat = [[3], [5], [8]]
//        Output: 5
//        Explanation: Sorting matrix elements gives us {3,5,8}. Hence, 5 is median.
//        Constraints:
//        1 <= mat.size(), mat[0].size() <= 400
//        1 <= mat[i][j] <= 2000
//
//        Expected Complexities
//        Time Complexity: O(n log m * log(maxVal – minVal))
//        Auxiliary Space: O(1)
public class MedianInRowWiseSortedMatix_HARD {
    public int median_sol1(int mat[][]) {
        int low = 0, high = 2000;
        int size = mat.length * mat[0].length;

        while(low <= high) {
            int mid = (low + high)/2;
            int lesserElements = findLesser(mat, mid);

            if(lesserElements <= size/2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high+1;
    }
    private int findLesser(int[][] mat, int ele) {
        int count = 0;
        for(int i=0; i<mat.length; i++) {
            int low = 0, high = mat[i].length-1;
            while(low <= high) {
                int mid = (low + high)/2;
                if(mat[i][mid] <= ele) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += high + 1;
        }
        return count;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int median_sol2(int mat[][]) {
        int n = mat.length, m = mat[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple t1, Tuple t2) {
                return t1.ele - t2.ele;
            }
        });
        for(int i=0; i<n; i++) {
            pq.add(new Tuple(i, 0, mat[i][0]));
        }
        int count = n*m / 2;
        while(count > 0) {
            Tuple t = pq.poll();
            if(t.j < m-1) {
                Tuple tup = new Tuple(t.i, t.j+1, mat[t.i][t.j+1]);
                pq.add(tup);
            }
            count--;
        }
        return pq.peek().ele;
    }
    public class Tuple {
        int i, j, ele;
        public Tuple(int i, int j, int ele) {
            this.i = i;
            this.j = j;
            this.ele = ele;
        }
    }
}
