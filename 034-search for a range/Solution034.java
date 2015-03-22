public class Solution {
    //Attempt1: 256ms
    public int[] searchRange(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }        

    private int[] binarySearch(int[] A, int left, int right, int target) {
        if (right - left <= 1) {
            if (A[left] == target && A[right] == target)
                return new int[]{left, right};
            else if (A[left] == target && A[right] != target)
                return new int[]{left, left};
            else if (A[left] != target && A[right] == target)
                return new int[]{right, right};
            else
                return new int[]{-1, -1};

        }

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] > target)
                right = mid - 1;
            else if (A[mid] < target)
                left = mid + 1;
            else {
                int[] resultLeft = binarySearch(A, left, mid, target);
                int[] resultRight = binarySearch(A, mid, right, target);
                return new int[]{resultLeft[0], resultRight[1]};
            }
        }

        return new int[]{-1, -1};
    }
}