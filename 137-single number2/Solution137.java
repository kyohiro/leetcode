public class Solution137 {
    //Attempt1: 349ms - hashmap
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                if (map.get(n) == 2)
                    map.remove(n);
                else
                    map.put(n, map.get(n) + 1);
            }
            else
                map.put(n, 1);
        }
        
        for (int k : map.keySet()) {
            return k;
        }
        
        return 0;
    }

    //Attempt2: 365ms - bit manipulation
    public int singleNumber2(int[] nums) {
        int[] array = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; ++i) {
                array[i] += n & 1;
                n = n >>> 1;
            }
        }

        int ret = 0;
        for (int i = 31; i >= 0; --i) {
            ret = ret << 1;
            int rem = array[i] % 3;
            ret += rem; 
        }

        return ret;
    }
}