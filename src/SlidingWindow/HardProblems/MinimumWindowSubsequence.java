package SlidingWindow.HardProblems;

public class MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        int n = S.length(), m = T.length();
        int si = 0, ei = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int i1 = i;
            int i2 = 0;
            while(i2 < m && i1 < n) {
                if(S.charAt(i1) == T.charAt(i2)) i2++;
                i1++;
            }
            if(i2 == m && ei-si > i1-i) {
                si = i;
                ei = i1;
            }
        }
        if(ei == Integer.MAX_VALUE) return "";
        return S.substring(si, ei);
    }
}
