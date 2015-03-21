public class Solution031 {
    //Attempt1: 237ms
    public void nextPermutation(int[] num) {
        int len = num.length, sortIdx = 0;
        for (int i = len - 1; i > 0; --i) {
            if (num[i - 1] < num[i]) {
                sortIdx = i; //start sorting from next digital
                int min = num[i], minIdx = i;
                //find next larger
                for (int j = i + 1; j < len; ++j) {
                    if (num[j] > num[i - 1] && num[j] < min) {
                        min = num[j];
                        minIdx = j;
                    }
                }
                //swap
                num[minIdx] = num[i - 1];
                num[i - 1] = min;
                break;
            }
        }

        Arrays.sort(num, sortIdx, len);
    }
}