package Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i=1; i<n; i++) {
            if(intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            } else {
                res.add(intervals[i-1]);
            }
        }
        res.add(intervals[n-1]);
        return res.toArray(new int[res.size()][2]);
    }
}
