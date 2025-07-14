package SlidingWindow.MediumProblems;

import java.util.HashMap;
import java.util.Map;

//904. Fruit Into Baskets https://leetcode.com/problems/fruit-into-baskets/description/
//        Solved
//        Medium
//        Topics
//        Companies
//        You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//        You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//        You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//        Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//        Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//        Given the integer array fruits, return the maximum number of fruits you can pick.
//
//
//
//        Example 1:
//
//        Input: fruits = [1,2,1]
//        Output: 3
//        Explanation: We can pick from all 3 trees.
//        Example 2:
//
//        Input: fruits = [0,1,2,2]
//        Output: 3
//        Explanation: We can pick from trees [1,2,2].
//        If we had started at the first tree, we would only pick from trees [0,1].
//        Example 3:
//
//        Input: fruits = [1,2,3,2,2]
//        Output: 4
//        Explanation: We can pick from trees [2,3,2,2].
//        If we had started at the first tree, we would only pick from trees [1,2].
//
//
//        Constraints:
//
//        1 <= fruits.length <= 105
//        0 <= fruits[i] < fruits.length
public class FruitsIntoBasket {
    public int totalFruit_sol1(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = fruits.length;
        int res = 0;
        while(j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if(map.size() <= 2) {
                res = Math.max(res, j-i+1);
            } else {
                while(map.size() > 2) {
                    int f = map.get(fruits[i]);
                    if(f == 1) map.remove(fruits[i]);
                    else map.put(fruits[i], f-1);
                    i++;
                }
            }
            j++;
        }
        return res;
    }
    public int totalFruit_sol2(int[] fruits) {
        int basket1 = -1, basket2 = -1;
        int c1 = 0, c2 = 0;
        int i = 0, j = 0, n = fruits.length;
        int res = 0;
        while(j < n) {
            if(c1 == 0 && (c2 == 0 || basket2 != fruits[j])) {
                basket1 = fruits[j];
                c1++;
                j++;
            } else if(basket1 == fruits[j]) {
                c1++;
                j++;
            } else if(c2 == 0) {
                basket2 = fruits[j];
                c2++;
                j++;
            } else if(basket2 == fruits[j]) {
                c2++;
                j++;
            } else {
                if(basket1 == fruits[i]) {
                    c1--;
                } else if(basket2 == fruits[i]) {
                    c2--;
                }
                i++;
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
