public class Solution075 {
    //Attempt1: 436ms - two pass
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) ++count0;
            else if (nums[i] == 1) ++count1;
        }
        
        count1 += count0;
        for (int i = 0; i < nums.length; ++i) {
            if (i < count0) nums[i] = 0;
            else if (i < count1) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    //Attempt2: 260ms - one pass
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int index0 = 0, index2 = nums.length - 1;
        for (int i = 0; i <= index2;) {
            if (nums[i] == 1) {
                if (nums[index2] == 0) swap(nums, i, index2);
                else ++i;
            }
            else if (nums[i] == 0) {
                if (i != index0) swap(nums, i, index0++);
                else ++i;
            }
            else {
                if (i != index2) swap(nums, i, index2--);
                else ++i;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}