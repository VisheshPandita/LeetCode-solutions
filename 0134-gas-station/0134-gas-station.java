class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalExcess=0;
        int localExcess=0;
        int startStation=0;

        for(int i=0; i<gas.length; i++) {
            int nextGasAtStation = gas[i] - cost[i];

            totalExcess += nextGasAtStation;
            localExcess += nextGasAtStation;

            if(localExcess<0) {
                startStation = i+1;
                localExcess=0;
            }
        }

        return totalExcess>=0 ? startStation : -1;
    }
}