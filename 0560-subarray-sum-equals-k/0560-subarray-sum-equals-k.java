class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);

        int currentSum=0;
        int count=0;

        for(int num: nums){
            currentSum += num;

            if(prefixSumCount.containsKey(currentSum-k)){
                count += prefixSumCount.get(currentSum-k);
            }

            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}