class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr1=0;
        int ptr2=0;
        int count=0;

        while(ptr2<nums.length){
            if(nums[ptr2]==val){
                ptr2++;
            }else{
                count++;
                nums[ptr1] = nums[ptr2];
                ptr1++;
                ptr2++;
            }
        }

        return count;
    }
}