public class Solution011 {
    //Attempt1: 265ms
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int a = area(height, left, right);
            max = a > max ? a : max;
            if (height[left] < height[right])
                ++left;
            else
                --right;
        }
        return max;
    }

    private int area(int[] height, int left, int right) {
        return height[left] < height[right] ? height[left] * (right - left) : height[right] * (right - left);
    }
}
