import java.util.Arrays;

public class Solution004 {
    //Attempt1: 420ms
    //O(m+n) solution
    public double findMedianSortedArrays1(int A[], int B[]) {
        int sizeA = A.length, sizeB = B.length;
        int sizeC = A.length + B.length;
        int[] C = new int[sizeC];

        int idxA = 0, idxB = 0, idxC = 0;
        for (;idxC < sizeC && idxA < sizeA && idxB < sizeB;++idxC) {
            if (A[idxA] <= B[idxB])
                C[idxC] = A[idxA++];
            else
                C[idxC] = B[idxB++];
        }

        if (idxA != sizeA) {
            while (idxA < sizeA)
                C[idxC++] = A[idxA++];
        }
        if (idxB != sizeB) {
            while (idxB < sizeB)
                C[idxC++] = B[idxB++];
        }


        if (sizeC % 2 == 0)
            return (double)(C[sizeC/2-1] + C[sizeC/2]) / 2;
        else
            return C[sizeC / 2];
    }

    //Attempt2: 390ms
    //O(log(m+n)) solution
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if (total % 2 != 0)
            return findKth(A, B, total/2+1);
        else
            return (double)(findKth(A, B, total/2) + findKth(A, B, total/2+1))/2;
    }

    private double findKth(int[] A, int[] B, int k) {
        if (A.length > B.length)
            return findKth(B, A, k);
        if (A.length == 0)
            return B[k - 1];
        if (k == 1)
            return A[0] < B[0] ? A[0] : B[0];

        int pa = k/2 < A.length ? k/2 : A.length;
        int pb = k - pa;
        if (A[pa-1] < B[pb-1])
            return findKth(Arrays.copyOfRange(A, pa, A.length), B, k-pa);
        else if (A[pa-1] > B[pb-1])
            return findKth(A, Arrays.copyOfRange(B, pb, B.length), k-pb);
        else
            return A[pa-1];

    }

}
