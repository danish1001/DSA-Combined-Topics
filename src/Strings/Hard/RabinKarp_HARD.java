package Strings.Hard;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp_HARD {
    List<Integer> rabinKarp(String pattern, String text) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        int totalChars = 256, mod = 1001;
        int patHash = 0, textHash = 0;
        int pow = 1;

        for(int i=m-1; i>=0; i--) {
            patHash = (patHash + pow * pattern.charAt(i)) % mod;
            textHash = (textHash + pow * text.charAt(i)) % mod;
            pow = (pow * totalChars) % mod;
        }
        pow = 1;
        for(int i=0; i<m-1; i++) {
            pow = (pow * totalChars) % mod;
        }
        int i=0, j=m;

        while(j < n) {
            if(patHash == textHash) {
                if(isEqual(pattern, text, i, m)) res.add(j-m+1);
            }
            textHash = (totalChars * (textHash - pow * text.charAt(i)) + text.charAt(j)) % mod;
            if(textHash < 0) textHash += mod;
            i++;
            j++;
        }
        if(patHash == textHash) {
            if(isEqual(pattern, text, i, m)) res.add(j-m+1);
        }
        return res;
    }
    private boolean isEqual(String pat, String text, int ind, int m) {
        for(int i=0; i<m; i++) {
            if(pat.charAt(i) != text.charAt(i + ind)) return false;
        }
        return true;
    }
}
