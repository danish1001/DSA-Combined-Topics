package Array.Hard;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/description/
//        Solved
//        Easy
//        Topics
//        Companies
//        Given an integer numRows, return the first numRows of Pascal's triangle.
//
//        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//        Example 1:
//
//        Input: numRows = 5
//        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//        Example 2:
//
//        Input: numRows = 1
//        Output: [[1]]
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> base = new ArrayList<>();
        base.add(1);
        res.add(base);
        if(numRows == 1) return res;

        for(int i=1; i<numRows; i++) {
            res.add(new ArrayList<>());
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    res.get(i).add(1);
                } else {
                    List<Integer> list = res.get(i-1);
                    res.get(i).add(list.get(j-1) + list.get(j));
                }
            }
        }
        return res;
    }
}
