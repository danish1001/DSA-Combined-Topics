package DynamicProgramming.OneDimensionalDP;

public class nthFibonacciNumber {
    public int nthFibNumRecursion(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return nthFibNumRecursion(n-1) + nthFibNumRecursion(n-2);
    }
    public int nthFibNumMemorization(int n, int[] dp) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = nthFibNumMemorization(n-1, dp) + nthFibNumMemorization(n-2, dp);
    }
    public int nthFibNumTabulation(int n) {
        int[] dp = new int[n+1];
        if(n > 0) dp[1] = 1;
        for(int i=2; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % ((int) 1e9 + 7);
        }
        return dp[n];
    }

    public int nthFibNumTabulationSpaceOptimized(int n) {
        int prev2 = 0, prev1 = 0;
        if(n > 0) prev1 = 1;
        for(int i=2; i<n+1; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
