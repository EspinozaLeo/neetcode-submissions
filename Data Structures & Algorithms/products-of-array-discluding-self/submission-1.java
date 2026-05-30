class Solution {
    public int[] productExceptSelf(int[] nums) {
        // O(n^2) solution
        // int numsLength = nums.length;
        // int[] prodArr = new int[numsLength];

        // for(int i = 0;i < numsLength; i++){
        //     int prod = 1;
        //     for(int j = 0; j < numsLength; j++){
        //         if(i != j){
        //             prod *= nums[j];
        //         }
        //     }
        //     prodArr[i] = prod;
        // }
        // return prodArr;

        int numsLength = nums.length;
        int[] resultArr = new int[numsLength];
        int[] prefixArr = new int[numsLength];
        int[] postfixArr = new int[numsLength];

        //fill in prefix
        for(int i = 0; i < numsLength; i++){
            if(i == 0){
                prefixArr[0] = 1;
            } else{
                prefixArr[i] = nums[i-1] * prefixArr[i - 1];
            }
        }
        //fill in postfix
        for(int i = numsLength - 1; i >= 0; i--){
            if(i == numsLength - 1){
                postfixArr[i] = 1;
            } else{
                postfixArr[i] = nums[i+1] * postfixArr[i+1];
            }
        }
        //fill in resultArr
        for(int i = 0; i < numsLength; i++){
            resultArr[i] = postfixArr[i] * prefixArr[i];
        }
        return resultArr;
    }
}  
