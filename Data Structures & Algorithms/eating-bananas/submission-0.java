class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int minRate = 0;
        int sumHours = 0;
        int l = 1, r = maxPile;
        while(l <= r){
            //calculate rate - hour = pile[i] // k
            int k = l + ((r - l) / 2);
            sumHours = 0;
            for(int i = 0; i < piles.length; i++){
                sumHours = sumHours + (piles[i] + k - 1) / k;
            }
            if(sumHours <= h){
                minRate = k;
                r = k - 1;
            } else{
                l = k + 1;
            }
        }
        return minRate;
    }
}