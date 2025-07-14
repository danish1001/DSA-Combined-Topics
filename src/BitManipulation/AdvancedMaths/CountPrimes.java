package BitManipulation.AdvancedMaths;

public class CountPrimes {
    public int countPrimes(int n) {
        int[] prime = new int[n+1];
        for(int i=2; i*i <= n; i++) {
            if(prime[i] == 0) {
                for(int j=i+i; j<n; j += i) {
                    prime[j] = -1;
                }
            }
        }
        int primeCount = 0;
        for(int i=2; i<n; i++) {
            if(prime[i] != -1) primeCount++;
        }
        return primeCount;
    }
}
