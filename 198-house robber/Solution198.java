public class Solution198 {
    //Attempt1 - timeout by recursion
    public int rob(int[] num) {
        return subRob(num, 0);
    }

    public int subRob(int[] num, int to) {
        if (to == num.length - 1)
            return num[to];
        else if (to > num.length - 1)
            return 0;
        else {
            int s1 = num[to] + subRob(num, to + 2);
            int s2 = subRob(num, to + 1);
            return s1 > s2 ? s1 : s2;
        }
    }

    //Attempt2 - 184ms DP
    public int rob2(int[] num) {
        if (num == null || num.length == 0)
            return 0;

        int last = 0, max = 0, tmp = 0;
        for (int i = 0; i < num.length; ++i) {
            tmp = max;
            max = Math.max(last + num[i], max)
            last = tmp;
        }

        return max;
    }

}