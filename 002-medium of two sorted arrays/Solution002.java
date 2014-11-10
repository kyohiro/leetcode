public class Solution002 {
    public double findMedianSortedArrays(int A[], int B[]) {
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
}