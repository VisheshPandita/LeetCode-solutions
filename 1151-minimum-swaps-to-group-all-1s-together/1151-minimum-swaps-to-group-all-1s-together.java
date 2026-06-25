class Solution {
    public int minSwaps(int[] data) {
        int totalOne=0;

        for(int bit: data) {
            if(bit==1) totalOne++;
        }

        int minZero=0;
        int i;
        for(i=0;i<totalOne;i++) {
            if(data[i] == 0) minZero++;
        }

        int currZero = minZero;
        while(i<data.length){
            if(data[i - totalOne] == 0){
                currZero--;
            }

            if(data[i] == 0) {
                currZero++;
            }

            i++;

            minZero = Math.min(minZero, currZero);
        }

        return minZero;
    }
}