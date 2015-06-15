public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        else
            //make k 0-based
            return subFind(nums, nums.length - k, 0, nums.length - 1) ;
    }

    private int subFind(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start, right = end;

        while (true) {
            while (nums[left] < pivot && left < right)
                ++left;
            while (nums[right] >= pivot && left < right)
                --right;

            if (left == right)
                break;
            swap(nums, left, right);
        }
        swap(nums, left, end);

        if (k == left)
            return pivot;
        else if (k < left)
            return subFind(nums, k, start, left - 1);
        else 
            return subFind(nums, k, left + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}