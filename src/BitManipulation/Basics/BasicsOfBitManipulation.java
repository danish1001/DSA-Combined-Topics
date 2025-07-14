package BitManipulation.Basics;

import java.util.ArrayList;
import java.util.List;

public class BasicsOfBitManipulation {
    public void bitManipulation(int num, int i) {
        int ithBit = ((num & (1 << i)) == 0) ? 0 : 1;
        int setIthBit = (num | (1 << i));

        int clearIthBit_way1 = (num & (~(1 << i)));
        int clearIthBit_way2 = (ithBit == 0) ? num : (num ^ (1 << i));

        System.out.print(ithBit + " " + setIthBit + " " + clearIthBit_way1);
    }

    public int setRightMostUnsetBit_sol1(int n) {
        int turnedBitN = n ^ (n + 1);
        return turnedBitN | n;
    }
    public int setRightMostUnsetBit_sol2(int n) {
        return (n | (n+1));
    }
    public List<Integer> swapTwoNumbers(int a, int b) {
        List<Integer> res = new ArrayList<>();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        res.add(a);
        res.add(b);

        return res;
    }
}
