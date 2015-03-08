public class Solution016 {
    //Attempt1: 244ms
    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; ++i) {
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                int diff = target - sum;
                int abs = Math.abs(diff);

                if (abs == 0)
                    return target;
                else if (abs < min) {
                    min = abs;
                    result = sum;
                }

                if (diff > 0)
                    ++left;
                else
                    --right;
            }
        }
        return result;
    }
}
