public class Solution089 {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<Integer>();
        if (n == 0) {
            results.add(0);
            return results;
        }

        results.addAll(grayCode(n - 1));
        int add = (int)Math.pow(2, n - 1);
        for (int i = results.size() - 1; i >= 0; --i) {
            results.add(results.get(i) + add);
        }

        return results;
    }
}