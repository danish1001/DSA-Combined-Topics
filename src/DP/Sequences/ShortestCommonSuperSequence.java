package DP.Sequences;

public class ShortestCommonSuperSequence {
    public static String shortestSuperSequence(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;

        while(i > 0 && j > 0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                sb.append(a.charAt(i-1));
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]) {
                sb.append(b.charAt(j-1));
                j--;
            } else {
                sb.append(a.charAt(i-1));
                i--;
            }
        }
        sb.reverse();

        String res = "";
        if(i > 0) res = a.substring(0, i) + res;
        if(j > 0) res = b.substring(0, j) + res;

        return res + sb.toString();
    }
}
