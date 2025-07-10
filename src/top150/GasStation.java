package top150;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/7/6 21:17
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<len; i++){

            sum += gas[i]-cost[i];
            if(sum <= min){
                min = sum;
                index = i;
            }

        }
        if(sum < 0)
            return -1;
        System.out.println(index);
        return (index +1)%len;

    }

    public static void main(String[] args) {
        int[] gas = new int[]{11,4,7,1,0};
        int[] cost = new int[]{2,5,5,9,1};
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(gas,cost);
    }
}
