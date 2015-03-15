public class Solution026 {
    //Attempt1: 255ms
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;
        int idx = 1, last = A[0];
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != last) {
                last = A[i];
                A[idx++] = A[i];
            }
        }

        return idx;
    }
}
