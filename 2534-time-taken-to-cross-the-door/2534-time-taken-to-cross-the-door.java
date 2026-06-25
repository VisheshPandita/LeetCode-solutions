class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] ans = new int[n];
        
        // Standard FIFO Queues (Storing the person's index, NOT the time)
        Queue<Integer> enterQueue = new ArrayDeque<>();
        Queue<Integer> exitQueue = new ArrayDeque<>();

        int time = 0;
        int doorState = 1; // 1 = Exit Priority (Default for an unused door)
        int i = 0; // Pointer for the incoming array of people

        // Continue while people are waiting to arrive, or people are in the rooms
        while (i < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            
            // 1. THE TIME-JUMP
            // If the waiting rooms are empty, warp time to the next arrival.
            if (enterQueue.isEmpty() && exitQueue.isEmpty() && time < arrival[i]) {
                time = arrival[i];
                // The door was unused during the jump, so it resets to Exit Priority!
                doorState = 1; 
            }
            
            // 2. LOAD THE WAITING ROOMS
            // Anyone whose arrival time is <= our current time gets put in a queue
            while (i < n && arrival[i] <= time) {
                if (state[i] == 0) {
                    enterQueue.offer(i);
                } else {
                    exitQueue.offer(i);
                }
                i++;
            }
            
            // 3. THE BOUNCER (Rule Resolution)
            if (!enterQueue.isEmpty() && !exitQueue.isEmpty()) {
                // Traffic jam! The Bouncer looks at the doorState sign.
                if (doorState == 1) {
                    ans[exitQueue.poll()] = time;
                } else {
                    ans[enterQueue.poll()] = time;
                }
            } else if (!exitQueue.isEmpty()) {
                // Only exit line has people
                ans[exitQueue.poll()] = time;
                doorState = 1; // Door was just used to exit
            } else if (!enterQueue.isEmpty()) {
                // Only enter line has people
                ans[enterQueue.poll()] = time;
                doorState = 0; // Door was just used to enter
            }
            
            // The person takes 1 second to cross
            time++;
        }
        
        return ans;
    }
}