public class Solution {
    //Attempt1: 207ms
    public void merge(int A[], int m, int B[], int n) {
        int length = m + n;
        while (n > 0)
            A[--length] = (m == 0 || A[m - 1] < B[n - 1]) ? B[--n] : A[--m];
    }
}