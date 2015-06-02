public class Solution220 {
    //Attempt1: 496ms
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 1 || t < 0)
            return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; ++i) {
            long idx = t == 0 ? (long)(nums[i] - Integer.MIN_VALUE) : (long)(nums[i] - Integer.MIN_VALUE) / t;
            if ((map.containsKey(idx)) ||
                (map.containsKey(idx + 1) && Math.abs(map.get(idx + 1) - nums[i]) <= t) ||
                (map.containsKey(idx - 1) && Math.abs(map.get(idx - 1) - nums[i]) <= t))
                return true;
            else {
                if (map.keySet().size() >= k) {
                    long lastIndex = t == 0 ? (long)(nums[i - k] - Integer.MIN_VALUE) : (long)(nums[i - k] - Integer.MIN_VALUE) / t;
                    map.remove(lastIndex);
                }
                map.put(idx, (long)nums[i]);
            }
        }

        return false;
    }
}