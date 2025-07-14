package Strings.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstringsWithExactlyKDistinctCharacters {

    // easiest solution
    // atleast(k) =     K + k+1 + K+2
    // atleast(K+1) =       K+1 + K+2
    // subtracting it = K
    public int countSubstr_sol1(String s, int k) {
        return atleast(s, k) - atleast(s, k+1);
    }
    private int atleast(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, n = s.length();
        int res = 0;

        while(i < n) {
            while(j < n && map.size() < k) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            if(j == n && map.size() < k) break;
            res += n-j+1;
            remove(map, s.charAt(i));
            i++;
        }
        return res;
    }

    // --------------------------------------------------------------------
    public int countSubstr_sol2(String s, int k) {
        if(k == 1) return solve(s);
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int i=0, j=0, ind=0, n=s.length();
        int res = 0;
        while(ind < n) {
            while(i < n && map1.size() < k-1) {
                map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
                i++;
            }
            while(i < n && map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
                i++;
            }

            while(j < n && map2.size() < k) {
                map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            while(j < n && map2.containsKey(s.charAt(j))) {
                map2.put(s.charAt(j), map2.get(s.charAt(j)) + 1);
                j++;
            }
            res += j-i;
            remove(map1, s.charAt(ind));
            remove(map2, s.charAt(ind));
            ind++;
        }
        return res;
    }
    private int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int res = 0;
        while(i < n) {
            if(j < n && map.size() < 1) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            while(j < n && map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                j++;
            }
            res += j-i;
            remove(map, s.charAt(i));
            i++;
        }
        return res;
    }

    // common method
    private void remove(Map<Character, Integer> map, char ch) {
        int f = map.get(ch);
        if(f == 1) map.remove(ch);
        else map.put(ch, f-1);
    }
}
