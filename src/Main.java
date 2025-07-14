import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Integer> it: map.entrySet()) {

        }
    }
    public static int median(int mat[][]) {
        int n = mat.length, m = mat[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple t1, Tuple t2) {
                return t1.ele - t2.ele;
            }
        });
        for(int i=0; i<n; i++) {
            pq.add(new Tuple(i, 0, mat[i][0]));
        }
        int count = n*m / 2;
        int res = -1;
        while(count > 0) {
            Tuple t = pq.poll();
            res = t.ele;
            if(t.j < m-1) {
                Tuple tup = new Tuple(t.i, t.j+1, mat[t.i][t.j+1]);
                pq.add(tup);
            }
        }
        return res;
    }
    public static class Tuple {
        int i, j, ele;
        public Tuple(int i, int j, int ele) {
            this.i = i;
            this.j = j;
            this.ele = ele;
        }
    }
    private static  int getVerticesCount(List<List<Integer>> adj, int node, boolean[] visited) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            count++;
            List<Integer> list = adj.get(q.poll());
            for(int ele: list) {
                if(!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
        return count;
    }
//    public static class Tuple {
//        int i1, i2, sum;
//        public Tuple(int i1, int i2, int sum) {
//            this.i1 = i1;
//            this.i2 = i2;
//            this.sum = sum;
//        }
//        @Override
//        public boolean equals(Object o) {
//            if(this == o) return true;
//            if(o == null || getClass() != o.getClass()) return false;
//            Tuple tuple = (Tuple) o;
//            return this.i1 == tuple.i1 && this.i2 == tuple.i2;
//        }
//        @Override
//        public int hashCode() {
//            return Objects.hash(i1, i2, sum);
//        }
//    }
//    public static class DUP {
//        int i, j;
//        public DUP(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//    }
//    static int findPlatform(int arr[], int dep[]) {
//        int n = arr.length;
//        TrainTime[] time = new TrainTime[n];
//        for(int i=0; i<n; i++) {
//            time[i] = new TrainTime(arr[i], dep[i]);
//        }
//        Arrays.sort(time, new Comparator<TrainTime>() {
//            @Override
//            public int compare(TrainTime t1, TrainTime t2) {
//                return t1.arr - t2.arr;
//            }
//        });
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(time[0].dep);
//
//        int res = 1;
//        for(int i=1; i<n; i++) {
//            while(!pq.isEmpty() && time[i].arr > pq.peek()) {
//                pq.poll();
//            }
//            pq.add(time[i].dep);
//            res = Math.max(res, pq.size());
//        }
//        return res;
//    }
//    public static class TrainTime {
//        int arr, dep;
//        public TrainTime(int arr, int dep) {
//            this.arr = arr;
//            this.dep = dep;
//        }
//    }
//    public static class TupleT {
//        int node, value, ext;
//        public TupleT(int node, int value, int ext) {
//            this.ext = ext;
//            this.value = value;
//            this.node = node;
//        }
//    }
//    public static void printSubset(int[] arr, int n, List<Integer> res) {
//        if(n < 0) {
//            System.out.println(res);
//            return;
//        }
//        res.add(arr[n]);
//        printSubset(arr, n-1, res);
//        res.remove(res.size()-1);
//        printSubset(arr, n-1, res);
//    }
//    private static long fact(int n, int stop) {
//        long res = 1;
//
//        while(n > stop) {
//            res = (res * n);
//            System.out.println("=> " + res);
//            n--;
//        }
//        System.out.println(res);
//        return res;
//    }
//    private static class Tup {
//        Node node;
//        boolean canPick;
//        public Tup(Node node, boolean canPick) {
//            this.node = node;
//            this.canPick = canPick;
//        }
//    }
//    public static class Node {
//        int data;
//        Node next;
//        public Node(int data) {
//            this.data = data;
//        }
//    }
//
//    public static void display(TreeSet<Pair> set) {
//        System.out.println("----");
//        for(Pair p: set) System.out.print(" -> (" + p.node + ", " + p.dis + ")");
//    }
//    public static class Pair {
//        int dis, node;
//        public Pair(int node, int dis) {
//            this.dis = dis;
//            this.node = node;
//        }
//    }
//    public static boolean solveSudokuUtil(int[][] board, int row, int col) {
//        if(row == 9) {
//            return true;
//        }
//        if(row < 9 && col < 9 && board[row][col] != 0) {
//            return solveSudokuUtil(board, row, col+1);
//        }
//        if(col < 9) {
//            for(int num=1; num<=9; num++) {
//                if(isValid(board, row, col, num)) {
//                    board[row][col] = num;
//                    boolean response = solveSudokuUtil(board, row, col+1);
//                    if(response) return true;
//                    board[row][col] = 0;
//                }
//            }
//        } else {
//            boolean response = solveSudokuUtil(board, row+1, 0);
//            if(response) return true;
//        }
//        return false;
//    }
//    public static boolean isValid(int[][] board, int row, int col, int num) {
//        for(int i=0; i<9; i++) {
//            if(board[row][i] == num) return false;
//            if(board[i][col] == num) return false;
//        }
//        row = (row/3) * 3;
//        col = (col/3) * 3;
//        for(int i = row; i < row + 3; i++) {
//            for(int j = col; j < col + 3; j++) {
//                if(board[i][j] == num) return false;
//            }
//        }
//        return true;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static boolean checkValidString(String s) {
//        return checkValidString(s, new Stack<Character>());
//    }
//
//    public static boolean checkValidString(String s, Stack<Character> stack) {
//        System.out.println("Running ...");
//        for(int i=0; i<s.length(); i++) {
//            char ch = s.charAt(i);
//            if(ch == '*') {
//                if(checkValidString("(" + s.substring(i+1), deepCopy(stack))) return true;
//                if(checkValidString(")" + s.substring(i+1), deepCopy(stack))) return true;
//            } else if(ch == '(') {
//                stack.add(ch);
//            } else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
//                stack.pop();
//            } else {
//                return false;
//            }
//        }
//        if(stack.isEmpty()) return true;
//        return false;
//    }
//
//    public static Stack<Character> deepCopy(Stack<Character> stack) {
//        Stack<Character> copy = new Stack<>();
//        for(int i=0; i<stack.size(); i++) {
//            copy.add(stack.get(i));
//        }
//        return copy;
//    }
//
//    public static class Tuple {
//        int value;
//        int weight;
//        double valByW;
//        public Tuple(int value, int weight, double valByW) {
//            this.value = value;
//            this.weight = weight;
//            this.valByW = valByW;
//        }
//    }
//
//
//
//    long substrCount (String S, int K) {
//        Map<Character, Integer> left = new HashMap<>();
//        Map<Character, Integer> right = new HashMap<>();
//        int i = 0, j = 0, n = S.length();
//        long res = 0;
//
//        while(i < n) {
//            while(i < n && left.size() != K-1) {
//                left.put(S.charAt(i), left.getOrDefault(S.charAt(i), 0) + 1);
//                i++;
//            }
//            while(i < n && left.containsKey(S.charAt(i))) {
//                left.put(S.charAt(i), left.getOrDefault(S.charAt(i), 0) + 1);
//                i++;
//            }
//
//            while(j < n && right.size() != K) {
//                right.put(S.charAt(j), right.getOrDefault(S.charAt(j), 0) + 1);
//                j++;
//            }
//            while(j < n && right.containsKey(S.charAt(j))) {
//                right.put(S.charAt(j), right.getOrDefault(S.charAt(j), 0) + 1);
//                j++;
//            }
//            res += (long) j-i;
//            i++;
//        }
//        return 1;
//    }
//
//    static int most_k_chars(String s, int k) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        int num = 0, left = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//            while (map.size() > k) {
//                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
//                if (map.get(s.charAt(left)) == 0) {
//                    map.remove(s.charAt(left));
//                }
//                left++;
//            }
//            num += i - left + 1;
//        }
//        return num;
//    }
//
//
//
//
//



}