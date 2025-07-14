package BitManipulation.AdvancedMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactorizationUsingSieve {
    int[] factor;
    int n = 200000;
    public void sieve() {
        factor = new int[n+1];
        for(int i=0; i<n; i++) {
            factor[i] = i;
        }

        for(int i=2; i*i<=n; i++) {
            if(factor[i] == i) {
                for(int j=i*i; j<=n; j += i) {
                    factor[j] = i;
                }
            }
        }
    }
    public List<Integer> findPrimeFactors(int N) {
        List<Integer> res = new ArrayList<>();

        while(N != 1) {
            res.add(factor[N]);
            N = N / factor[N];
        }
        Collections.sort(res);
        return res;
    }
}
