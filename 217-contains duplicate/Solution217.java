public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            if (set.contains(n))
                return true;
            else
                set.add(n);
        }
        return false;
    }
}