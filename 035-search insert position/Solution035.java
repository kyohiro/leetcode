public class Solution035 {
    //Attempt1: 229ms
    public int searchInsert(int[] A, int target) {
        int mid, left = 0, right = A.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] == target)
                return mid;
            else if (right - left <= 1) {
                if (target < A[left])
                    return left;
                else if (target > A[right])
                    return right + 1;
                else
                    return left + 1;
            }
            else if (A[mid] > target)
                right = mid - 1;
            else if (A[mid] < target)
                left = mid + 1;
        }
        return 0;
    }
}