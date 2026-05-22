class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] prodArr = new int[numsLength];

        for(int i = 0;i < numsLength; i++){
            int prod = 1;
            for(int j = 0; j < numsLength; j++){
                if(i != j){
                    prod *= nums[j];
                }
            }
            prodArr[i] = prod;
        }
        return prodArr;
    }
}  
