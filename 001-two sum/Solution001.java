import java.util.HashMap;
import java.util.Map;

public class Solution001 {
    //Attempt1: 249ms
    //Attempt2: 225ms
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i)
            map.put(numbers[i], i);

        for (int i = 0; i < numbers.length; ++i)
            if (map.containsKey(target - numbers[i])) {
                int another = map.get(target - numbers[i]);
                if (another != i)
                    return new int[]{i + 1, another + 1}；
            }

        throw new IllegalArgumentException("No valid solition for input.");
    }
}
