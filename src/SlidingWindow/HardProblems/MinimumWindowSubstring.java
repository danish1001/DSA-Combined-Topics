package SlidingWindow.HardProblems;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow_sol1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), m = t.length();
        for(int i=0; i<m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int size = map.size();
        int i = 0, j = 0;
        int si = 0, ei = Integer.MAX_VALUE;

        while(j < n) {
            if(map.containsKey(s.charAt(j))) {
                int f = map.get(s.charAt(j));
                if(f == 1) size--;
                map.put(s.charAt(j), f-1);
            }
            if(size == 0) {
                while(i < n && size == 0) {
                    if(ei-si > j-i) {
                        si = i;
                        ei = j;
                    }
                    if(map.containsKey(s.charAt(i))) {
                        int f = map.get(s.charAt(i));
                        if(f == 0) size++;
                        map.put(s.charAt(i), f+1);
                    }
                    i++;
                }
            }
            j++;
        }
        if(ei == Integer.MAX_VALUE) return "";
        return s.substring(si, ei+1);
    }
    private void remove(Map<Character, Integer> map, char ch) {
        int f = map.get(ch);
        if(f == 1) map.remove(ch);
        else map.put(ch, f-1);
    }
    //-------------------------------------------------------------------------------------------
    public String minWindow_sol2(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int si = 0, ei = Integer.MAX_VALUE;

        while(j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(i < n && contains(tmap, map)) {
                if(ei-si > j-i) {
                    si = i;
                    ei = j;
                }
                remove(map, s.charAt(i));
                i++;
            }
            j++;
        }
        if(ei == Integer.MAX_VALUE) return "";
        return s.substring(si, ei+1);
    }
    private boolean contains(Map<Character, Integer> tMap, Map<Character, Integer> map) {
        if(tMap.size() > map.size()) return false;

        for(Map.Entry<Character, Integer> it: tMap.entrySet()) {
            if(!map.containsKey(it.getKey())) return false;
            if(map.get(it.getKey()) < it.getValue()) return false;
        }
        return true;
    }
}
