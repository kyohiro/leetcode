import java.util.HashMap;
import java.util.Map;

public class Solution001 {
    //Attemp1: 249ms
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i)
            map.put(numbers[i], i);

        for (int i = 0; i < numbers.length; ++i)
            if (map.containsKey(target - numbers[i])) {
                int another = map.get(target - numbers[i]);
                if (another != i)
                    return another > i ? new int[]{i + 1, another + 1} : new int[]{another + 1, i + 1};
            }

        throw new IllegalArgumentException("No valid solition for input.");
    }
}
