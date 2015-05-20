public class Solution077 {
    //Attempt1: 304ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>(); 
        if (n <= 0 || k <= 0)
            return results;

        subCombine(0, n, k, new ArrayList<Integer>(), results);
        return results;
    }

    private void subCombine(int s, int n, int k, List<Integer> list, List<List<Integer>> results) {
        if (k == 0) {
            List<Integer> ret = new ArrayList<Integer>(list);
            results.add(ret);
        }

        for (int i = s; i < n; ++i) {
            list.add(i + 1);
            subCombine(i + 1, n, k - 1, list, results);
            list.remove(list.size() - 1);
        }
    }
}