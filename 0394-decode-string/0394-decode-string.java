class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(currentStr);
                currentStr = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                while (repeatTimes-- > 0) {
                    decoded.append(currentStr);
                }
                currentStr = decoded;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}