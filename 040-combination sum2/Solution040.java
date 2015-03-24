public class Solution {
    //Attempt1: 259ms
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        combinationSubset(num, 0, target, new ArrayList<Integer>(), results);
        return results;
    }

    private void combinationSubset(int[] num, int first, int target, List<Integer> currentList, List<List<Integer>> results) {
        if (target == 0)
            results.add(new ArrayList<Integer>(currentList));
        else if (target <= 0)
            return;

        for (int i = first; i < num.length; ++i) {
            currentList.add(num[i]);
            combinationSubset(num, i + 1, target - num[i], currentList, results);
            currentList.remove(currentList.size() - 1);

            while (i < num.length - 1 && num[i] == num[i + 1])
                ++i;
        }
    }
}
