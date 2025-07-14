package RecursionBacktracking.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {

    public List<List<Integer>> subsets_sol1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        solve(res, e, nums, 0, nums.length);
        return res;
    }

    public void solve(List<List<Integer>> res, List<Integer> output, int[] arr, int i, int n) {
        if(i >= n) {
            res.add(new ArrayList<Integer>(output));
            return;
        }
        output.add(arr[i]);
        solve(res, output, arr, i+1, n);
        output.remove(output.size()-1);
        solve(res, output, arr, i+1, n);
    }
    public List<List<Integer>> subsets_sol2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = (1 << nums.length);
        int m = nums.length;

        for(int i=0; i<n; i++) {
            int ele = i;
            List<Integer> list = new ArrayList<>();
            for(int j=m-1; j>=0; j--) {
                if((ele & (1 << j)) != 0) list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }


    public List<List<Integer>> subsets_sol3(int[] nums) {
        return solve(nums, 0);
    }
    private List<List<Integer>> solve(int[] nums, int i) {
        if(i == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> recRes = solve(nums, i+1);
        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> list: recRes) {
            result.add(list);

            List<Integer> copy = new ArrayList<>(list);
            copy.add(nums[i]);
            result.add(copy);
        }
        return result;
    }
}
