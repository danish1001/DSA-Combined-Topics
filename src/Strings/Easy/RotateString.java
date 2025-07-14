package Strings.Easy;

public class RotateString {
    public boolean rotateString_sol1(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if((s+s).indexOf(goal) != -1) return true;
        return false;
    }
    public boolean rotateString_sol2(String s, String goal) {
        if(s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }
}
