public class Solution053 {
    //Attempt1: 345ms
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int localSum = sum + nums[i];
            sum = localSum > nums[i] ? localSum : nums[i];
            max = sum > max ? sum : max;
        }
        return max;
    }
}