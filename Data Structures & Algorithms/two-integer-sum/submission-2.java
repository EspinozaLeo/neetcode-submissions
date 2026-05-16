class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int diff = 0;
        for(int i = 0; i < nums.length; i++){
            myMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            diff = target - nums[i];
            if(myMap.containsKey(diff) && myMap.get(diff) != i){
                return new int[]{i, myMap.get(diff)};
            }

        }

        return new int[0];
    }
}
