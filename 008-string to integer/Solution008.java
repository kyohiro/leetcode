public class Solution {
    //Attempt1: 241ms
    public int atoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        str = str.trim();
        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        }
        else if (str.charAt(0) == '+')
            str = str.substring(1);

        if (str.length() == 0)
            return 0;

        long result = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            int asc = (int)c;
            if (asc < 48 || asc > 57)
                break;
            else
                result = result * 10 + asc - 48;

            if (!isNegative && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (isNegative && result - 1 > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }

        return isNegative ? -1 * (int)result : (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().atoi("-2147483648"));
    }
}
