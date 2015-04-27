public class Solution045 {
    //Attempt1: 405ms
    public int jump(int[] nums) {
        int max = 0, step = 0, current = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            max = Math.max(nums[i] + i, max);
            if (i == current) {
                ++step;
                current = max;
            }
        }

        return step;
    }
}