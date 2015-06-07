public class Solution060 {
    public String getPermutation(int n, int k) {
        int array = new int[n];
        for (int i = 0; i < n; ++i)
            array[i] = i;
        permutate(array, n - 1, k);
    }

    private void permutate(int[] array, int bound, int k) {
        if (k == 1)
            return array;
        for (int i = 0; i < bound; ++i) {
            swap(array, i, bound);
            permutate(array, bound - 1, k - 1);
            swap(array, i, bound);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}