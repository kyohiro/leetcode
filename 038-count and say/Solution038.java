public class Solution038 {
    //Attempt1: 292ms
    public String countAndSay(int n) {
        String last = "1";
        for (int i = 1; i < n; ++i)
            last = say(last);

        return last;
    }

    private String say(String last) {
        String said = "";
        int num = last.charAt(0) - '0', count = 1;
        for (int i = 1; i < last.length(); ++i) {
            int newNum = last.charAt(i) - '0';
            if (newNum == num) {
                ++count;
            }
            else {
                said += String.valueOf(count);
                said += String.valueOf(num);
                num = newNum;
                count = 1;
            }
        }
        said += String.valueOf(count);
        said += String.valueOf(num);

        return said;
    }
}