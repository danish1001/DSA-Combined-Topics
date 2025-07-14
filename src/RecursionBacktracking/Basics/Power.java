package RecursionBacktracking.Basics;

public class Power {
    long mod = 1000000007L;
    public long myPow(long x, int n) {
        return power(x, (long) n);
    }

    private long power(long x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        if(n % 2 == 0) {
            return power((x*x) % mod, n/2);
        } else {
            return (x * power(x, n-1)) % mod;
        }
    }

    // overloaded function
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE) return x * solve(x, n+1);
        return solve(x, n);
    }
    private double solve(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) return 1 / solve(x, -1*n);
        if(n % 2 == 0) {
            return solve(x*x, n/2);
        } else {
            return x * solve(x, n-1);
        }
    }
}
