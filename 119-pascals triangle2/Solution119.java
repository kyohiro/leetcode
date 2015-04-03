public class Solution119 {
    //Attempt1: 205ms
    public List<Integer> getRow(int rowIndex) {
        int[] array = new int[rowIndex + 1];
        array[0] = 1;
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = i - 1; j >= 1; --j) 
                array[j] = array[j - 1] + array[j];
            array[i] = 1;
        }

        List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; ++i)
            result.add(array[i]);
        return result;
    }
}