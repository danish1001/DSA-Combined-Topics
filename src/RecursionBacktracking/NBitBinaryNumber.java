package RecursionBacktracking;

public class NBitBinaryNumber {
    public void NBitBinaryNumberHaving1GreaterOrEqual0(int n, String output) {
        if(n == 0) {
            if(has0MoreOrEqual0Prefix(output))
                System.out.println(output);
            return;
        }
        NBitBinaryNumberHaving1GreaterOrEqual0(n-1, output + 0);
        NBitBinaryNumberHaving1GreaterOrEqual0(n-1, output + 1);
    }

    private boolean has0MoreOrEqual0Prefix(String input) {
        int one = 0;
        int zero = 0;

        for(int i=0; i<input.length(); i++) {
            int ch = input.charAt(i);
            if(ch == 48) {
                zero++;
            } else {
                one++;
            }
            if(one < zero) return false;
        }
        return true;
    }
}
