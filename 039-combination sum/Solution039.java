import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution039 {
    //Attempt1: 298ms 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSubSet(candidates, new ArrayList<List<Integer>>(), candidates.length - 1, target);
    }

    private List<List<Integer>> combinationSubSet(int[] candidates, List<List<Integer>> currentList, int last, int target) {
        if (target == 0)
            return currentList;
        else if (target < 0 || last < 0)
            return new ArrayList<List<Integer>>();
        else {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 1; i <= target / candidates[last]; ++i) {
                ret.addAll(combinationSubSet(candidates, appendToAll(currentList, candidates[last], i), last - 1, target - candidates[last] * i));
            }
            ret.addAll(combinationSubSet(candidates, currentList, last - 1, target));
            return ret;
        }
    }

    private List<List<Integer>> appendToAll(List<List<Integer>> currentList, int num, int times) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        if (currentList.isEmpty())
            currentList.add(new ArrayList<Integer>());

        for (List<Integer> l : currentList) {
            List<Integer> newArr = new ArrayList<Integer>();
            for (int i = 0; i < times; ++i)
                newArr.add(num);
            newArr.addAll(l);
            arrays.add(newArr);
        }
        return arrays;
    }

    //Attempt2: 323ms
    private void combinationSubSet2(int[] candidates, int start, int target, List<Integer> currentList, List<List<Integer>> result) {
        if (target < 0)
            return;
        else if (target == 0) {
            result.add(new ArrayList<Integer>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            currentList.add(candidates[i]);
            combinationSubSet2(candidates, i, target - candidates[i], currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }

}
