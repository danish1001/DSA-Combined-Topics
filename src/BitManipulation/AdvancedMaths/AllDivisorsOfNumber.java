package BitManipulation.AdvancedMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllDivisorsOfNumber {
    public static void print_divisors(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            if(n % i == 0) {
                res.add(i);
                if(n/i != i) res.add(n/i);
            }
        }
        Collections.sort(res);
        for(int ele: res) {
            System.out.print(ele + " ");
        }
    }
}
