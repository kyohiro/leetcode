public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        k = Math.abs(k);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                if (i - lastIndex <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return false;
    }
}