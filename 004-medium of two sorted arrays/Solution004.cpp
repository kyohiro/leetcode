#include <stdio.h>

//Attempt1: 48ms
class Solution004 {
public:
  double findMedianSortedArrays(int A[], int m, int B[], int n) {
    int total = m + n;
    if (total % 2 != 0)
      return findKth(A, m, B, n, total/2 + 1);
    else
      return (double)(findKth(A, m, B, n, total/2+1) + findKth(A, m, B, n, total/2))/2;
  }

private:
  double findKth(int A[], int m, int B[], int n, int k) {
    if (m > n)
      return findKth(B, n, A, m, k);
    if (m == 0)
      return B[k - 1];
    if (k == 1)
      return A[0] > B[0] ? B[0] : A [0];

    int pa = k/2 > m ? m : k/2;
    int pb = k - pa;
    if (A[pa - 1] > B[pb - 1])
      return findKth(A, m, &B[pb], n - pb, k - pb);
    else if (A[pa - 1] < B[pb - 1])
      return findKth(&A[pa], m - pa, B, n, k - pa);
    else
      return A[pa - 1];
  }
};
