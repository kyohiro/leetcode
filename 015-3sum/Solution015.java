public class Solution015 {
    //Attempt1: 333ms
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < num.length; ++i) {
            if (map.containsKey(num[i]) == false)
                map.put(num[i], 1);
            else
                map.put(num[i], map.get(num[i]) + 1);
        }

        if (map.containsKey(0) && map.get(0) >= 3)
            results.add(Arrays.asList(new Integer[]{0, 0, 0}));
        for (Integer key : map.keySet()) {
            if (key != 0 && map.get(key) > 1 && map.containsKey(0 - key * 2))
                if (key < 0 - key * 2)
                    results.add(Arrays.asList(new Integer[]{key, key, 0 - key * 2}));
                else
                    results.add(Arrays.asList(new Integer[]{0 - key * 2, key, key}));
        }

        List<Integer> values = new ArrayList<Integer>(map.keySet());
        for (int i = 0; i < values.size() - 2; ++i) {
            int target = 0 - values.get(i);
            int left = i + 1, right = values.size() - 1;
            while (left < right) {
                int sum = values.get(left) + values.get(right);
                if (sum > target)
                    --right;
                else if (sum < target)
                    ++left;
                else
                    results.add(Arrays.asList(new Integer[]{values.get(i), values.get(left++), values.get(right--)}));
            }
        }

        return results;
    }
}
