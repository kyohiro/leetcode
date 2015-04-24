public class Solution134 {
    //Attempt1: 335ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length)
            return -1;
        
        int start = 0, total = 0, sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            int rem = gas[i] - cost[i];
            sum += rem;
            total += rem; 
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        if (total < 0)
            return -1;
        else
            return start;
    }
}