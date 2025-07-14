package Strings.Hard;

public class KMPStringMatchingAlgo_HARD {
    private int KMP(String haystack, String needle) {
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        int[] lps = getLPS(needle);

        while(i < n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == m) return i-m;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }
    private int[] getLPS(String s) {
        int i = 0, j = 1, n = s.length();
        int[] lps = new int[n];
        while(j < n) {
            if(s.charAt(i) == s.charAt(j)) {
                lps[j] = i+1;
                i++;
                j++;
            } else {
                if(i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i-1];
                }
            }
        }
        return lps;
    }
}
