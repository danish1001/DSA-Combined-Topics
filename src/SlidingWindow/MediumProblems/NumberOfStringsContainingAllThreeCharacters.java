package SlidingWindow.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfStringsContainingAllThreeCharacters {
    public int numberOfSubstrings_sol1(String s) {
        int n = s.length();
        int[] lastPos = {-1, -1, -1};

        int res = 0;
        for(int pos=0; pos<n; pos++) {
            lastPos[s.charAt(pos)-'a'] = pos;
            res += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }
        return res;
    }
    //--------------------------------------------------------------------------------------------------------------
    public int numberOfSubstrings_sol2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int res = 0;

        while(i < n) {
            while(j < n && map.size() < 3) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            if(map.size() == 3) {
                res += n-j+1;
            }
            if(j == n && map.size() < 3) break;
            remove(map, s.charAt(i));
            i++;
        }
        return res;
    }
    private void remove(Map<Character, Integer> map, char ch) {
        int f = map.get(ch);
        if(f == 1) map.remove(ch);
        else map.put(ch, f-1);
    }
    //--------------------------------------------------------------------------------------------------------------
    public int numberOfSubstrings_sol3(String s) {
        int[] map = new int[3];
        int i = 0, j = 0, n = s.length();
        int res = 0;

        while(i < n) {
            while(j < n && size(map) != 3) {
                map[s.charAt(j)-'a']++;
                j++;
            }
            if(size(map) == 3) {
                res += n-j+1;
            }
            if(j == n && size(map) < 3) break;
            map[s.charAt(i)-'a']--;
            i++;
        }
        return res;
    }
    private int size(int[] map) {
        int count = 0;
        if(map[0] > 0) count++;
        if(map[1] > 0) count++;
        if(map[2] > 0) count++;
        return count;
    }
}
