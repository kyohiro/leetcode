public class Solution091 {
    //Attempt1: 300ms
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0; 

        int counts0 = 1, counts1 = 1;
        for (int i = 2; i <= s.length(); ++i) {
            int counts2 = s.charAt(i - 1) != '0' ? counts1 : 0;
            counts2 += (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') ? counts0 : 0;
            counts0 = counts1;
            counts1 = counts2;
        }

        return counts1;
    }
}