class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int minRate = 0;
        int l = 1, r = maxPile;
        while(l <= r){
            //calculate rate a.k.a midpoint
            int k = l + ((r - l) / 2);
            int sumHours = 0;
            //iterate over all piles using k summing up the hours
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