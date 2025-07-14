package RecursionBacktracking.Basics;

public class StringToInteger_atoi {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        if(s.isEmpty()) return 0;
        if(s.charAt(0) == '-') sign = -1;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        s = removeZeroPrefix(s);
        long res = solve(s, 0, s.length(), 0, sign);
        if((int) res == Integer.MIN_VALUE || (int) res == Integer.MAX_VALUE) return (int) res;
        return (int) sign * (int) res;
    }

    public long solve(String s, int i, int n, long res, int sign) {
        if(sign == -1 && (res) >= Integer.MAX_VALUE) return Integer.MIN_VALUE;
        if(sign == 1 && res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(i == n) return res;
        char ch = s.charAt(i);
        if(!(ch >= '0' && ch <= '9')) return res;
        int ele = ch - '0';
        res = (res * 10) + (long) ele;
        return solve(s, i+1, n, res, sign);
    }

    public String removeZeroPrefix(String s) {
        int i = 0, n = s.length();
        while(i < n && s.charAt(i) == '0') i++;
        return s.substring(i);
    }
}
