public class Solution046 {
    //Attempt1: 268ms - backtracking permutation
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (num.length != 0)
            subPermutate(num, num.length - 1, results);
        return results;
    }
    
    private void subPermutate(int[] num, int boundIndex, List<List<Integer>> results) {
        if (boundIndex == 0) {
            List<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < num.length; ++i)
                l.add(num[i]);
            results.add(l);
        }
        for (int i = 0; i <= boundIndex; ++i) {
            swap(num, i, boundIndex);
            subPermutate(num, boundIndex - 1, results);
            swap(num, i, boundIndex);
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}