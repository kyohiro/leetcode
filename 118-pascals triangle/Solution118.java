public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return results;
        if (numRows >= 1) {
            List<Integer> first = new ArrayList<Integer>();
            first.add(1);
            results.add(first);
        }
        
        for (int i = 1; i < numRows; ++i) {
            List<Integer> last = results.get(i - 1);
            List<Integer> crt = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    crt.add(1);
                else
                    crt.add(last.get(j - 1) + last.get(j));
            }
            results.add(crt);
        }
        
        return results;
    }
}