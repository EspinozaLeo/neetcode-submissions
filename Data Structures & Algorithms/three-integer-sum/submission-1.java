class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            //check if current num equals previous value in nums
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            //pretty much do 2 sum again
            while(l < r){
                //remember to include nums[i]
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                } else if(sum < 0){
                    l++;
                } else{
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    //move l until it is not duplicate (say i is 2 and i + 1 is 2 also then we should skip)
                    l++;
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                }
            }
        }
        return result;
    }
}