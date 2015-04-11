public class Solution189 {
    //Attempt1: 255ms - flip subarray for 3 times
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        int r = l - k;
        flip(nums, 0, r - 1);
        flip(nums, r, l - 1);
        flip(nums, 0, l - 1);
    }

    private void flip(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }
}