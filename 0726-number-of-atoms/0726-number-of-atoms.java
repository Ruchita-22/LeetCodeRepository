class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);

            // Case 1: Opening parenthesis
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            }

            // Case 2: Closing parenthesis
            else if (c == ')') {
                Map<String, Integer> currMap = stack.pop();
                i++;

                // Parse multiplier (e.g. ")2" → multiply inner map by 2)
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int mul = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                // Multiply all counts inside parentheses
                if (mul > 1) {
                    currMap.replaceAll((k, v) -> v * mul);
                }

                // Merge into map below (stack top)
                Map<String, Integer> peekMap = stack.peek();
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    peekMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
                }
            }

            // Case 3: Element name + count
            else {
                int start = i;
                i++; // move past uppercase letter

                // get lowercase letters if any
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);

                // parse optional number
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                // add to current top map
                stack.peek().merge(element, count, Integer::sum);
            }
        }

        // Sort final map alphabetically
        Map<String, Integer> sortedMap = new TreeMap<>(stack.peek());

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) sb.append(entry.getValue());
        }

        return sb.toString();
    }
}
