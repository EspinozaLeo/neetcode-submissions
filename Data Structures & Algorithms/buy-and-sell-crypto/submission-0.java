class Solution {
    public int maxProfit(int[] prices) {
        int maxMoneys = 0;
        int minSoFar = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            profit = prices[i] - minSoFar;
            maxMoneys = Math.max(maxMoneys, profit);
        }
        return maxMoneys;
    }
}