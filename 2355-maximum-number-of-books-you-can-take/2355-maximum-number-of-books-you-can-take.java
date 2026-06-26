class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        
        // dp[i] stores the max books we can take if we stop at shelf i
        long[] dp = new long[n];
        
        // Monotonic stack to store indices. 
        // We maintain indices j such that (books[j] - j) is strictly increasing.
        Stack<Integer> stack = new Stack<>();
        long maxTotalBooks = 0;

        for (int i = 0; i < n; i++) {
            // Pop elements that do not act as a bottleneck for the current i
            // Condition: books[j] - j >= books[i] - i
            while (!stack.isEmpty() && books[stack.peek()] - stack.peek() >= books[i] - i) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // There is no bottleneck to the left.
                // We can take an arithmetic progression ending at books[i].
                // Note: The sequence stops if we hit index 0 OR if the required books drop to 1.
                long count = Math.min(i + 1, books[i]);
                long startValue = books[i] - count + 1;
                long endValue = books[i];
                
                // Sum of arithmetic progression: n * (a1 + an) / 2
                dp[i] = (count * (startValue + endValue)) / 2;
            } else {
                // We found a bottleneck at index j.
                int j = stack.peek();
                long count = i - j;
                
                // We take an arithmetic progression from j+1 to i
                long startValue = books[i] - count + 1;
                long endValue = books[i];
                long currentSum = (count * (startValue + endValue)) / 2;
                
                // The total is the sum of this sequence PLUS the optimal answer ending at j
                dp[i] = dp[j] + currentSum;
            }

            // Push current index to the stack
            stack.push(i);
            
            // Keep track of the global maximum
            maxTotalBooks = Math.max(maxTotalBooks, dp[i]);
        }

        return maxTotalBooks;
    }
}