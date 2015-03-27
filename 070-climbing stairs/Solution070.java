public class Solution070 {
    //Attempt1: 189ms - cache all step results
    private int[] cache = new int[10000];
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (cache[n] != 0)
            return cache[n];

        cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return cache[n];
    }

    //Attempt2: 209ms - non recursive
    public int climbStairs2(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int s1 = 1, s2 = 2;
        int result = 0;
        for (int i = 2; i < n; ++i) {
            result = s1 + s2;
            s1 = s2;
            s2 = result;
        }

        return result;
    }
}
