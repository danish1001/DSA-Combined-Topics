package RecursionBacktracking.Basics;

import java.util.List;

public class SortArray {
    public void sortArrayUsingRecursion(List<Integer> input) {
        if(input.isEmpty()) return;
        int temp = input.remove(0);
        sortArrayUsingRecursion(input);
        insertIntoArrayAtSortedLocation(input, temp);
    }
    private void insertIntoArrayAtSortedLocation(List<Integer> input, int ele) {
        if(input.isEmpty() || input.get(input.size()-1) <= ele) {
            input.add(ele);
            return;
        }
        int temp = input.remove(input.size()-1);
        insertIntoArrayAtSortedLocation(input, ele);
        input.add(temp);
    }
}
