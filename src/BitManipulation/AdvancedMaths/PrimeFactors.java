package BitManipulation.AdvancedMaths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public int[] AllPrimeFactors_sol1(int N) {
        List<Integer> res = new ArrayList<>();

        for(int i=1; i*i<= N; i++) {
            if(N % i == 0) {
                if(isPrime(i)) res.add(i);
                if(i != N/i && isPrime(N/i)) res.add(N/i);
            }
        }
        int[] sol = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            sol[i] = res.get(i);
        }
        return sol;
    }
    public int[] AllPrimeFactors_sol2(int N) {
        List<Integer> res = new ArrayList<>();

        int num = 2;

        while(num <= N) {
            if(N % num == 0 && isPrime(num)) {
                res.add(num);
                while(N % num == 0) {
                    N = N / num;
                }
            }
            num++;
        }

        int[] sol = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            sol[i] = res.get(i);
        }
        return sol;
    }

    // helper function
    private boolean isPrime(int n) {
        if(n == 1) return false;
        int count = 0;
        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
