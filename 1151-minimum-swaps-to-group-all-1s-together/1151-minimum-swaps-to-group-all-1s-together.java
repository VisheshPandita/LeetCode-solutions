class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            totalOnes += num;
        }

        if (totalOnes <= 1) {
            return 0;
        }

        int currentOnesInWindow = 0;
        for (int i = 0; i < totalOnes; i++) {
            currentOnesInWindow += data[i];
        }

        int maxOnesInWindow = currentOnesInWindow;

        for (int i = totalOnes; i < data.length; i++) {
            currentOnesInWindow += data[i];
            
            currentOnesInWindow -= data[i - totalOnes];

            if (currentOnesInWindow > maxOnesInWindow) {
                maxOnesInWindow = currentOnesInWindow;
            }
        }

        return totalOnes - maxOnesInWindow;
    }
}