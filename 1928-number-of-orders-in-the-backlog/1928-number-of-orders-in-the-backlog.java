import java.util.*;

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        // Max-heap for buy (higher price first)
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Min-heap for sell (lower price first)
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            
            if (type == 0) { // buy order
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] s = sell.peek();
                    int trade = Math.min(amount, s[1]);
                    amount -= trade;
                    s[1] -= trade;
                    if (s[1] == 0) sell.poll();
                }
                if (amount > 0) buy.offer(new int[]{price, amount});
            } else { // sell order
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] b = buy.peek();
                    int trade = Math.min(amount, b[1]);
                    amount -= trade;
                    b[1] -= trade;
                    if (b[1] == 0) buy.poll();
                }
                if (amount > 0) sell.offer(new int[]{price, amount});
            }
        }

        long total = 0;
        final int MOD = 1_000_000_007;
        for (int[] b : buy) total = (total + b[1]) % MOD;
        for (int[] s : sell) total = (total + s[1]) % MOD;
        return (int) total;
    }
}
