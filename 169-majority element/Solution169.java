public class Solution169 {
    //Attempt1: 252ms
    public int majorityElement(int[] num) {
        if (num.length == 0)
            return 0;
        int hot = num[0], count = 1;
        for (int i = 1; i < num.length; ++i) {
            if (num[i] == hot)
                ++count;
            else {
                --count;
                if (count <= 0) {
                    hot = num[i];
                    count = 1;
                }
            }
        }
        return hot;
    }
}