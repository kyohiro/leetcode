public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        if (nums == null || nums.length == 0)
            return results;

        int first = nums[0];
        for (int i = 1; i <= nums.length; ++i) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == first)
                    results.add(String.valueOf(first));
                else
                    results.add(first + "->" + nums[i - 1]);
                if (i != nums.length)
                    first = nums[i];
            }
        }
        return results; 
    }
}