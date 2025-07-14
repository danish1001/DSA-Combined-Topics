package Strings.Hard;

public class RepeatedStringMatch_HARD {
    public int repeatedStringMatch(String a, String b) {
        int i = 0, n = b.length()/a.length() + 2;
        String searchText = a;
        while(i < n) {
            if(rabinKarp(searchText, b)) return i+1;
            else searchText += a;
            i++;
        }
        return -1;
    }
    private boolean rabinKarp(String text, String pat) {
        int n = text.length(), m = pat.length();
        if(n < m) return false;
        int tHash = 0, pHash = 0;
        int pow = 1;
        int totalChars = 256;
        int mod = 101;

        for(int i=m-1; i>=0; i--) {
            pHash = (pHash + pat.charAt(i) * pow) % mod;
            tHash = (tHash + text.charAt(i) * pow) % mod;
            pow = (pow * totalChars) % mod;
        }
        pow = 1;
        for(int i=0; i<m-1; i++) {
            pow = (pow * totalChars) % mod;
        }
        int i = 0, j = m;

        while(j < n) {
            if(tHash == pHash && isEqual(text, i, j, pat)) return true;
            tHash = ((tHash - text.charAt(i) * pow) * totalChars + text.charAt(j)) % mod;
            if(tHash < 0) tHash += mod;
            i++;
            j++;

        }
        if(tHash == pHash && isEqual(text, i, j, pat)) return true;
        return false;
    }
    private boolean isEqual(String text, int low, int high, String pat) {
        int i = low;
        while(i < high) {
            if(text.charAt(i) != pat.charAt(i-low)) return false;
            i++;
        }
        return true;
    }
}
