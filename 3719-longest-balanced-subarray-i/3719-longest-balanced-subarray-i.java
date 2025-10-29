class Solution {
    public int longestBalanced(int[] nums) {
        int maxLength=0;

        for(int left=0;left<nums.length;left++){
            int evenCount=0;
            int oddCount=0;
            Set<Integer> cache = new HashSet<>();
            for(int right=left;right<nums.length;right++){
                if(!cache.contains(nums[right])){
                    if(nums[right]%2==0){
                        evenCount++;
                    }else if(nums[right]%2!=0){
                        oddCount++;
                    }
                    cache.add(nums[right]);
                }
                if(evenCount == oddCount){
                    maxLength = Math.max(maxLength, right-left+1);
                }
            }
        }

        return maxLength;
    }
}