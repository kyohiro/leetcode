public class Solution080 {
	//Attempt1: 360ms
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = 1, last = nums[0], index = 1;
        for (int i = 1; i < nums.length; ++i) {
            ++ret;
            nums[index++] = nums[i];
            if (nums[i] == last) {
                while (++i < nums.length && nums[i] == last);
                if (i < nums.length) {
                    last = nums[i];
                    nums[index++] = last;
                    ++ret;
                }
            }
            else 
                last = nums[i];

        }
	        
        return ret;
	}
}