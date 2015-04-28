public class Solution202 {
    //Attempt1: 272ms
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            set.add(n);
            n = calculate(n);
            if (n == 1)
                return true;
            else if (set.contains(n))
                return false;
            else
                set.add(n);
        }
    }
    
    private int calculate(int n) {
        int ret = 0;
        while (n != 0) {
            int x = n % 10;
            ret += x * x;
            n /= 10;
        }
        return ret;
    }
}